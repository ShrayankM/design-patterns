package org.example.questions.pubSub;

public class Person implements Subscriber {
	private final String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public boolean receiveEvent(Data data) {
		System.out.println("Person{" + this.name + "} received: " + data);
		return true;
	}

	@Override
	public void discontinueSubscription(Publisher publisher) {
		System.out.println("Person = " + name + " discontinued subscription of = " + publisher.getTopicName());
		publisher.removeSubscriber(this);
	}
}
