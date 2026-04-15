package org.example.questions.hotelBooking.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PricingStrategy {
	BigDecimal calculatePrice(Room room, LocalDateTime startDate, LocalDateTime endDate);
}
