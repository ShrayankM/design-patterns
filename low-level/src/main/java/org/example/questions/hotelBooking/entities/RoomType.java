package org.example.questions.hotelBooking.entities;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum RoomType {
	SINGLE(BigDecimal.valueOf(10.0)),
	DOUBLE(BigDecimal.valueOf(15.0)),
	DELUXE(BigDecimal.valueOf(30.0)),
	SUITE(BigDecimal.valueOf(45.0));

	private final BigDecimal basePrice;

	RoomType(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
}
