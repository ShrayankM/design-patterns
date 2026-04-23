package org.example.questions.pubSub;

public class Government implements Subscriber {
	@Override
	public boolean receiveEvent(Data data) {
		System.out.println("Government received: " + data);
		return true;
	}

	@Override
	public void discontinueSubscription(Publisher publisher) {
		publisher.removeSubscriber(this);
	}
}
