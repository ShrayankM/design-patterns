package org.example.questions.notification;

import lombok.Getter;
import lombok.Setter;


@Setter
public class Message {
	@Getter
	private String data;
	@Getter
	private MessagePriority messagePriority;
	@Getter
	private User user;
//	@Getter
//	private List<NotificationChannel> notificationChannelList;

	@Getter
	private NotificationChannel notificationChannel;
	private MessageStatus messageStatus;
	@Getter
	private Long retryCount;

	public void viewMessage() {
		System.out.println("Data: " + data
				+ " | Priority: " + messagePriority
				+ " | Status: " + messageStatus
				+ " | RetryCount: " + retryCount
				+ " | Channel: " + notificationChannel.viewNotificationChannel()
		);
	}
}
