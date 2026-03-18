package org.example.observerPattern;

public class Company implements Subscriber {
	@Override
	public void receiveSubscription(Edition edition) {
		System.out.println("Company received their subscription");
		System.out.println(edition);
	}
}
