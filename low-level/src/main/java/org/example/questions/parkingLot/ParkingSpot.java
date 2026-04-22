package org.example.questions.parkingLot;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class ParkingSpot {
	private String id;
	private Vehicle vehicle;
	private VehicleSize vehicleSize;

	public ParkingSpot(VehicleSize vehicleSize) {
		this.id = UUID.randomUUID().toString();
		this.vehicle = null;
		this.vehicleSize = vehicleSize;
	}

	public void parkVehicle(Vehicle vehicle) {
		if (vehicle.getVehicleSize().equals(this.vehicleSize)) {
			this.vehicle = vehicle;
		} else {
			System.out.println("Vehicle size does not match, cannot park vehicle");
		}
	}

	public boolean isSpotVacant() {
		return Objects.isNull(vehicle);
	}

	public void unparkVehicle() {
		this.vehicle = null;
	}
}
