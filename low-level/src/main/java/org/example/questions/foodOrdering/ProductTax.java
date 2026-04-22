package org.example.questions.foodOrdering;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductTax {
	private String id;
	private final String name;
	private final BigDecimal percentageTax;

	public ProductTax(String name, BigDecimal percentageTax) {
		this.name = name;
		this.percentageTax = percentageTax;
	}
}
