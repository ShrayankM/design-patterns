package org.example.questions.parkingLot;

import java.math.BigDecimal;

public class PeekHourPricingStrategy implements PricingStrategy {
	private final static BigDecimal peekHoursMultiplier = BigDecimal.valueOf(1.5);

	@Override
	public BigDecimal calculatePrice(Ticket ticket, BigDecimal inputFare) {
		if (ticket.getStartDate().getHour() >= 12 && ticket.getStartDate().getHour() <= 20) {
			inputFare = inputFare.multiply(peekHoursMultiplier);
		}
		return inputFare;
	}
}
