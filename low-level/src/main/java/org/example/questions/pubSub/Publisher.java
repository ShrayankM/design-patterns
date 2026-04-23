package org.example.questions.pubSub;

public interface Publisher {
	void addSubscriber(Subscriber subscriber);
	void removeSubscriber(Subscriber subscriber);
	void publishEvent(Data data);
	void notifySubscribers();
}
