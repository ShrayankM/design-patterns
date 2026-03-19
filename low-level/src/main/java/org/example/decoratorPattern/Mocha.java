package org.example.decoratorPattern;

import java.math.BigDecimal;

public class Mocha extends CondimentDecorator {

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
		this.condimentCost = new BigDecimal("3.99");
	}

	@Override
	public String getDescription() {
		return this.beverage.getDescription() + ", Mocha";
	}
}
