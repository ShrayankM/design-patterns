package org.example.questions.pubSub;

public interface Publisher {
	String getTopicName();
	void addSubscriber(Subscriber subscriber);
	void removeSubscriber(Subscriber subscriber);
	void publishEvent(Data data);
}
