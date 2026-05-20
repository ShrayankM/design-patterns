package org.example.questions.rideSharing;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
	private String id;
	private String name;
	private Status status;
	private UserType userType;
	private Location location;

	User() {
		this.id = UUID.randomUUID().toString();
	}
}
