package org.example.decoratorPattern;

import java.math.BigDecimal;

public interface Beverage {
	BigDecimal calculateCost();
	String getDescription();
}
