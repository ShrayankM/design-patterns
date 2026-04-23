package org.example.questions.pubSub;

public class Data {
	private final String data;
	private final String topicName;

	public Data(String data, String topicName) {
		this.data = data;
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "Data = [" + this.data + "], for topic {" + this.topicName + "}";
	}
}
