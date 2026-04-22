package org.example.questions.foodOrdering;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Product {
	private String id;
	private final String name;
	private BigDecimal price;
	private ProductTax productTax;

	public Product(String name, BigDecimal price, ProductTax productTax) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.price = price;
		this.productTax = productTax;
	}
}
