package org.example.observerPattern;

public class Person implements Subscriber {
	@Override
	public void receiveSubscription(Edition edition) {
		System.out.println("Normal user received their subscription");
		System.out.println(edition);
	}
}
