package org.example.questions.pubSub;

public class PubSubSystemDemo {
	public static void main(String[] args) {
		Publisher weatherTopic = new Topic("Weather-update");
		Publisher sportsTopic = new Topic("Sports-update");

		Government g = new Government();
		Person a = new Person("A");
		Person b = new Person("B");

		weatherTopic.addSubscriber(g);
		weatherTopic.addSubscriber(a);

		sportsTopic.addSubscriber(a);
		sportsTopic.addSubscriber(b);

		weatherTopic.publishEvent(new Data("Cloudy forecast for the day"));
		weatherTopic.publishEvent(new Data("Heavy rain expected tonight"));
		sportsTopic.publishEvent(new Data("India won the match by 10 runs"));

		weatherTopic.removeSubscriber(a);
		weatherTopic.publishEvent(new Data("Sunny skies tomorrow — A unsubscribed, should not receive this"));
	}
}
