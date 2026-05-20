package org.example.questions.rideSharing;

import lombok.Data;

import java.util.UUID;

@Data
public class Event {
	private String id;
	private Ride rideData;

	Event() {
		this.id = UUID.randomUUID().toString();
	}
}
