package org.example.questions.vendingMachine;

import lombok.Builder.ObtainVia;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product {
	private String id;
	private String name;
	private ProductType productType;
	private BigDecimal productPrice;

	public Product(String name, ProductType productType, BigDecimal productPrice) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.productType = productType;
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product-name = {" + this.name + "}, Type = [" + this.productType + "]";
	}
}
