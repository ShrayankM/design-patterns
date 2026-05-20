package org.example.questions.rideSharing;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Ride {
	private String id;
	private Location pickupLocation;
	private Location dropLocation;
	private User rider;
	private User driver;
	private BigDecimal estimatedDistance;
	private BigDecimal totalDistance;
	private BigDecimal estimatedFare;
	private BigDecimal totalFare;
	private RideStatus rideStatus;
	private VehicleType vehicleType;
	private LocalDateTime rideStartTime;
	private LocalDateTime rideEndTime;

	Ride() {
		this.id = UUID.randomUUID().toString();
	}

	Ride(RideRequest rideRequest) {
		this.id = UUID.randomUUID().toString();
		this.pickupLocation = rideRequest.getPickupLocation();
		this.dropLocation = rideRequest.getDropLocation();
		this.rider = rideRequest.getUser();
	}
}
