package org.example.questions.pubSub;

public class Data {
	private final String payload;
	private final long timestamp;

	public Data(String payload) {
		this.payload = payload;
		this.timestamp = System.currentTimeMillis();
	}

	public String getPayload() {
		return payload;
	}

	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "Data{payload='" + payload + "', timestamp=" + timestamp + "}";
	}
}
