package org.example.questions.pubSub;

import java.util.ArrayList;
import java.util.List;

public class WeatherUpdateTopic implements Publisher {
	private final List<Subscriber> subscriberList;
	private Data latestWeatherData;

	public WeatherUpdateTopic() {
		this.subscriberList = new ArrayList<>();
		this.latestWeatherData = null;
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
		this.latestWeatherData = data;
		notifySubscribers();
	}

	@Override
	public void notifySubscribers() {
		this.subscriberList.forEach(sub -> sub.receiveEvent(this.latestWeatherData));
	}
}
