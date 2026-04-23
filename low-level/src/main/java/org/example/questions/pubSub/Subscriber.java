package org.example.questions.pubSub;

public interface Subscriber {
	boolean receiveEvent(Data data);
}
