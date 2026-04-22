package org.example.questions.parkingLot;

import java.math.BigDecimal;
import java.util.Objects;

public class ParkingManager {
	private ParkingLot parkingLot;
	private PricingCalculator pricingCalculator;

	public ParkingManager(ParkingLot parkingLot, PricingCalculator pricingCalculator) {
		this.parkingLot = parkingLot;
		this.pricingCalculator = pricingCalculator;
	}

	public Ticket parkVehicle(Vehicle vehicle) {
		if (checkIfSpotAvailable(vehicle)) {
			ParkingSpot parkingSpot = this.parkingLot.findParkingSpot(vehicle);
			parkingSpot.parkVehicle(vehicle);
			Ticket ticket = new Ticket(parkingSpot);
			return ticket;
		}
		System.out.println("Parking spot is not available");
		return null;
	}

	public BigDecimal unparkVehicle(Ticket ticket) {
		ParkingSpot parkingSpot = ticket.getParkingSpot();
		parkingSpot.unparkVehicle();
		ticket.setEndDate();
		return pricingCalculator.calculatePricing(ticket);
	}

	public boolean checkIfSpotAvailable(Vehicle vehicle) {
		return Objects.nonNull(this.parkingLot.findParkingSpot(vehicle));
	}
}
