package org.example.questions.notification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class MessageService {
	private final ExecutorService executorService;
	private final PriorityQueue<Message> messageQueue;
	private final Queue<Message> retryQueue;
	private final AtomicLong maxRetryCount;
	private List<Message> messagesHistory;
	private final static Integer BASE_DELAY = 5;

	public MessageService() {
		this.messageQueue = new PriorityQueue<>(
				Comparator.comparingInt(a -> a.getMessagePriority().ordinal())
		);
		this.retryQueue = new LinkedList<>();
		this.executorService = Executors.newFixedThreadPool(10);
		this.maxRetryCount = new AtomicLong(5L);
		this.messagesHistory = new CopyOnWriteArrayList<>();
		startProcessing();
		startRetryProcessing();
	}

	private void startProcessing() {
		Thread consumerThread = new Thread(() -> {
			while (true) {
				Message message;
				synchronized (messageQueue) {
					while (messageQueue.isEmpty()) {
						try { messageQueue.wait(); } catch (InterruptedException e) {
							Thread.currentThread().interrupt();
							return;
						}
					}
					message = messageQueue.poll();
				}
				Message finalMessage = message;
				executorService.submit(() -> processMessage(finalMessage));
			}
		});
		consumerThread.setDaemon(true);
		consumerThread.start();
	}

	private void startRetryProcessing() {
		Thread retryThread = new Thread(() -> {
			while (true) {
				Message message;
				synchronized (retryQueue) {
					while (retryQueue.isEmpty()) {
						try { retryQueue.wait(); } catch (InterruptedException e) {
							Thread.currentThread().interrupt();
							return;
						}
					}
					message = retryQueue.poll();
				}
				Message finalMessage = message;
				executorService.submit(() -> {
					try {
						retryMessage(finalMessage);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				});
			}
		});
		retryThread.setDaemon(true);
		retryThread.start();
	}

	public void sendMessage(Template template, List<String> templateData, MessagePriority messagePriority,
			User user, List<NotificationChannel> notificationChannelList) {
		List<Message> messageList = buildMessage(template, templateData, messagePriority, user, notificationChannelList);
		for (Message message : messageList) {
			synchronized (messageQueue) {
				messageQueue.offer(message);
				messageQueue.notify();
			}
		}
	}

	private void processMessage(Message message) {
			NotificationChannel channel = message.getNotificationChannel();
			boolean isDelivered = channel.sendNotification(message);
			if (isDelivered) {
				message.setMessageStatus(MessageStatus.SENT);
				this.messagesHistory.add(message);
			} else {
				message.setMessageStatus(MessageStatus.RETRYING);
				message.setRetryCount(1L);
				synchronized (retryQueue) {
					retryQueue.offer(message);
					retryQueue.notify();  // <-- this is what L69 needs to be synchronized for
				}
			}

	}

	private void retryMessage(Message message) throws InterruptedException {
		Thread.sleep(message.getRetryCount() * BASE_DELAY);
		if (message.getRetryCount() >= maxRetryCount.get()) {
			message.setMessageStatus(MessageStatus.FAILED);
			messagesHistory.add(message);
			return;
		}
		message.setRetryCount(message.getRetryCount() + 1);
		NotificationChannel channel = message.getNotificationChannel();
			boolean isDelivered = channel.sendNotification(message);
			if (isDelivered) {
				message.setMessageStatus(MessageStatus.SENT);
				messagesHistory.add(message);
				return;
			}

		synchronized (retryQueue) {
			retryQueue.offer(message);
			retryQueue.notify();
		}
	}

	private List<Message> buildMessage(Template template, List<String> templateData, MessagePriority messagePriority,
			User user, List<NotificationChannel> notificationChannelList) {
		List<Message> messageList = new ArrayList<>();
		for (NotificationChannel notificationChannel : notificationChannelList) {
			Message message = new Message();
			String templateStr = template.returnTemplate(templateData);

			message.setData(templateStr);
			message.setMessagePriority(messagePriority);
			message.setUser(user);
			message.setNotificationChannel(notificationChannel);
			message.setMessageStatus(MessageStatus.PENDING);
			messageList.add(message);
		}
		return messageList;
	}

	public void viewMessageHistory() {
		List<Message> messagesList = this.messagesHistory;
		for (Message message : messagesList) {
			message.viewMessage();
		}
	}
}
