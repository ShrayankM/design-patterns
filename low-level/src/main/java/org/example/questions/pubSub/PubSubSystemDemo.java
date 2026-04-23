package org.example.questions.pubSub;

public class PubSubSystemDemo {
	public static void main(String [] args) {
		Publisher weatherUpdateTopic = new WeatherUpdateTopic();
		Publisher sportsUpdateTopic = new SportsUpdateTopic();

		Government g = new Government();
		Person a = new Person("A");
		Person b = new Person("B");

		weatherUpdateTopic.addSubscriber(g);
		weatherUpdateTopic.addSubscriber(a);

		sportsUpdateTopic.addSubscriber(a);
		sportsUpdateTopic.addSubscriber(b);

		weatherUpdateTopic.publishEvent(new Data("Cloudy forecast for the day", "Weather-update"));
		sportsUpdateTopic.publishEvent(new Data("India won the match by 10 runs", "Sports-update"));
	}
}
