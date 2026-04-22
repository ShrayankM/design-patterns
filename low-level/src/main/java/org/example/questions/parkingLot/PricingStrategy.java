package org.example.questions.parkingLot;

import java.math.BigDecimal;

public interface PricingStrategy {
	BigDecimal calculatePrice(Ticket ticket, BigDecimal inputFare);
}
