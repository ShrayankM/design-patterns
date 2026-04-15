package org.example.questions.hotelBooking.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Booking {
	private User user;
	private String id;
	private Hotel hotel;
	private List<Room> bookedRooms;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BookingStatus bookingStatus;
	private BigDecimal totalPrice;

	public Booking() {
		this.id = UUID.randomUUID().toString();
	}
}
