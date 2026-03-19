package org.example.decoratorPattern;

import java.math.BigDecimal;

public class DarkRoast implements Beverage {
	private final BigDecimal cost;
	private final String description;

	public DarkRoast() {
		this.cost = new BigDecimal("10.59");
		this.description = "Dark-Roast";
	}

	@Override
	public BigDecimal calculateCost() {
		return this.cost;
	}

	@Override
	public String getDescription() {
		return this.description;
	}
}
