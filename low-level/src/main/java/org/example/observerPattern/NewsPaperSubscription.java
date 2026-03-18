package org.example.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class NewsPaperSubscription implements Subscription {
	private List<Subscriber> subscriberList;
	private Edition latestEdition;

	public NewsPaperSubscription() {
		this.subscriberList = new ArrayList<>();
		this.latestEdition = null;
	}

	@Override
	public void updateLatestEdition(Edition edition) {
		this.latestEdition = edition;
		notifySubscribers();
	}

	@Override
	public void addSubscriber(Subscriber subscriber) {
		this.subscriberList.add(subscriber);
	}

	@Override
	public void removeSubscriber(Subscriber subscriber) {
		this.subscriberList.remove(subscriber);
	}

	@Override
	public void notifySubscribers() {
		this.subscriberList.forEach(subscriber ->
				subscriber.receiveSubscription(latestEdition));
	}
}
