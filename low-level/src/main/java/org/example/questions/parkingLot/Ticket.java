package org.example.questions.parkingLot;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Ticket {
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private ParkingSpot parkingSpot;
	private TicketStatus ticketStatus;

	public Ticket(ParkingSpot parkingSpot) {
		this.startDate = LocalDateTime.now();
		this.parkingSpot = parkingSpot;
		this.ticketStatus = TicketStatus.OCCUPIED;
	}

	public void setEndDate() {
		this.endDate = LocalDateTime.now();
		this.ticketStatus = TicketStatus.COMPLETED;
	}

	public VehicleSize getTicketVehicleSize() {
		return this.parkingSpot.getVehicle().getVehicleSize();
	}

	public void printTicketSummary() {

	}
}
