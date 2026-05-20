package org.example.questions.rideSharing;

import lombok.Data;

@Data
public class RideRequest {
	private User user;
	private Location pickupLocation;
	private Location dropLocation;
	private VehicleType vehicleType;
}
