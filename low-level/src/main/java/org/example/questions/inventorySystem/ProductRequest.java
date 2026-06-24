package org.example.questions.inventorySystem;

import lombok.Data;

@Data
public class ProductRequest {
	private Product product;
	private Long quantity;

	public ProductRequest(Product product, Long quantity) {
		this.product = product;
		this.quantity = quantity;
	}
}
