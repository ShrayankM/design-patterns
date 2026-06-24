package org.example.questions.inventorySystem;

import lombok.Data;

@Data
public class OrderProduct {
	private Product product;
	private Long quantity;

	public OrderProduct(Product product, Long quantity) {
		this.product = product;
		this.quantity = quantity;
	}
}
