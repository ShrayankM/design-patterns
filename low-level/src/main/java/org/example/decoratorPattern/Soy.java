package org.example.decoratorPattern;

import java.math.BigDecimal;

public class Soy extends CondimentDecorator {

	public Soy(Beverage beverage) {
		this.beverage = beverage;
		this.condimentCost = new BigDecimal("2.59");
	}

	@Override
	public String getDescription() {
		return this.beverage.getDescription() + ", Soy";
	}
}
