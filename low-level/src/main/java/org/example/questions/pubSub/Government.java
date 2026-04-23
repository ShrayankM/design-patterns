package org.example.questions.pubSub;

public class Government implements Subscriber {
	@Override
	public void receiveEvent(Data data) {
		System.out.println("Government received data = " + data.toString());
	}
}
