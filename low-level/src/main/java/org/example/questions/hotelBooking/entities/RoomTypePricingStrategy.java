package org.example.questions.hotelBooking.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RoomTypePricingStrategy implements PricingStrategy {
	@Override
	public BigDecimal calculatePrice(Room room, LocalDateTime startDate, LocalDateTime endDate) {
		return room.getRoomType().getBasePrice();
	}
}
