package org.example.questions.hotelBooking.entities;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DayPricingStrategy implements PricingStrategy {
	private static final BigDecimal WEEKEND_MULTIPLIER = BigDecimal.valueOf(1.5);

	@Override
	public BigDecimal calculatePrice(Room room, LocalDateTime startDate, LocalDateTime endDate) {
		BigDecimal totalPrice = BigDecimal.ZERO;

		long daysCount = ChronoUnit.DAYS.between(startDate, endDate);

		for (int i = 0; i < daysCount; i++) {
			LocalDateTime date = startDate.plusDays(i);

			DayOfWeek day = date.getDayOfWeek();
			BigDecimal basePrice = room.getRoomType().getBasePrice();

			if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
				totalPrice = totalPrice.add(basePrice.multiply(WEEKEND_MULTIPLIER));
			} else {
				totalPrice = totalPrice.add(basePrice);
			}
		}

		return totalPrice;
	}
}