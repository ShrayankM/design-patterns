package org.example.questions.rideSharing;

import lombok.Data;

@Data
public class UserRequest {
	private String name;
	private UserType userType;
	private Location currentLocation;
}
