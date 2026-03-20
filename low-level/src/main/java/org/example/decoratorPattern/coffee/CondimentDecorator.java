package org.example.decoratorPattern.coffee;

import java.math.BigDecimal;

public abstract class CondimentDecorator implements Beverage {
	Beverage beverage;
	BigDecimal condimentCost;

	@Override
	public BigDecimal calculateCost() {
		return this.beverage.calculateCost().add(this.condimentCost);
	}
}
