package org.example.decoratorPattern.coffee;

import java.math.BigDecimal;

public class Espresso implements Beverage {
	private final BigDecimal cost;
	private final String description;

	public Espresso() {
		this.cost = new BigDecimal("16.99");
		this.description = "Espresso";
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
