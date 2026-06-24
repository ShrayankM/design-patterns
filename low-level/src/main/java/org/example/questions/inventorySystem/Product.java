package org.example.questions.inventorySystem;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Product {
	private String code;
	private ProductType productType;
	private BigDecimal price;

	public Product(String code, ProductType productType, BigDecimal price) {
		this.code = code;
		this.productType = productType;
		this.price = price;
	}
}
