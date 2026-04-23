package org.example.questions.pubSub;

import java.util.ArrayList;
import java.util.List;

public class SportsUpdateTopic implements Publisher {
	private final List<Subscriber> subscriberList;
	private Data latestSportsData;

	public SportsUpdateTopic() {
		this.subscriberList = new ArrayList<>();
		this.latestSportsData = null;
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
	public void publishEvent(Data data) {
		this.latestSportsData = data;
		notifySubscribers();
	}

	@Override
	public void notifySubscribers() {
		this.subscriberList.forEach(sub -> sub.receiveEvent(this.latestSportsData));
	}
}
