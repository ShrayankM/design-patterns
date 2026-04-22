package org.example.questions.parkingLot;

import java.util.UUID;

public class Car implements Vehicle {
	private final String id;

	public Car() {
		this.id = UUID.randomUUID().toString();
	}

	@Override
	public String getRegistrationNumber() {
		return id;
	}

	@Override
	public VehicleSize getVehicleSize() {
		return VehicleSize.MEDIUM;
	}
}
