package org.example.observerPattern;

public interface Subscription {
	void addSubscriber(Subscriber subscriber);
	void removeSubscriber(Subscriber subscriber);
	void updateLatestEdition(Edition edition);
	void notifySubscribers();
}
