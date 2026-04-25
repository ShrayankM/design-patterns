package org.example.questions.pubSub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic implements Publisher {

    private static class DeadLetterEntry {
        final Subscriber subscriber;
        final Data data;

        DeadLetterEntry(Subscriber subscriber, Data data) {
            this.subscriber = subscriber;
            this.data = data;
        }
    }

    private final String topicName;
    private final List<Subscriber> subscribers;
    private final Queue<Data> messageQueue;
    private final List<DeadLetterEntry> deadLetterQueue;

    public Topic(String topicName) {
        this.topicName = topicName;
        this.subscribers = new CopyOnWriteArrayList<>();
        this.messageQueue = new LinkedList<>();
        this.deadLetterQueue = new ArrayList<>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public synchronized void publishEvent(Data data) {
        messageQueue.offer(data);
        drainQueue();
    }

    private void drainQueue() {
        while (!messageQueue.isEmpty()) {
            Data data = messageQueue.poll();
            for (Subscriber subscriber : subscribers) {
                boolean ack = subscriber.receiveEvent(data);
                if (!ack) {
                    System.out.println("[" + topicName + "] WARNING: subscriber failed to ack message: " + data);
                    deadLetterQueue.add(new DeadLetterEntry(subscriber, data));
                }
            }
        }
    }

    public synchronized void retryDeadLetters() {
        List<DeadLetterEntry> toRetry = new ArrayList<>(getDeadLetterQueue());
        deadLetterQueue.clear();
        for (DeadLetterEntry entry : toRetry) {
            System.out.println("[" + topicName + "] Retrying dead letter: " + entry.data);
            boolean ack = entry.subscriber.receiveEvent(entry.data);
            if (!ack) {
                System.out.println("[" + topicName + "] Retry failed, re-queuing to DLQ: " + entry.data);
                deadLetterQueue.add(entry);
            }
        }
    }

    public List<DeadLetterEntry> getDeadLetterQueue() {
        return Collections.unmodifiableList(deadLetterQueue);
    }

    public String getTopicName() {
        return topicName;
    }
}
