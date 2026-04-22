package org.example.questions.parkingLot;

import java.math.BigDecimal;
import java.util.List;

public class PricingCalculator {
	private List<PricingStrategy> pricingStrategyList;

	public PricingCalculator(List<PricingStrategy> pricingStrategyList) {
		this.pricingStrategyList = pricingStrategyList;
	}

	BigDecimal calculatePricing(Ticket ticket) {
		BigDecimal currentPrice = BigDecimal.valueOf(0L);
		for (PricingStrategy pricingStrategy : pricingStrategyList) {
			currentPrice = currentPrice.add(pricingStrategy.calculatePrice(ticket, currentPrice));
		}
		return currentPrice;
	}
}
