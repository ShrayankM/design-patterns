package org.example.questions.pubSub;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic implements Publisher {

    private final String topicName;
    private final List<Subscriber> subscribers;
    private final Queue<Data> messageQueue;
    private final Queue<Data> deadLetterQueue;

    public Topic(String topicName) {
        this.topicName = topicName;
        this.subscribers = new CopyOnWriteArrayList<>();
        this.messageQueue = new LinkedList<>();
        this.deadLetterQueue = new LinkedList<>();
    }

    @Override
    public synchronized void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public synchronized void removeSubscriber(Subscriber subscriber) {
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
                    this.deadLetterQueue.add(data);
                }
            }
        }
    }

    public String getTopicName() {
        return topicName;
    }
}
