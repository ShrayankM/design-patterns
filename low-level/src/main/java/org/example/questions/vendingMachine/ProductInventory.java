package org.example.questions.vendingMachine;

import lombok.Data;

@Data
public class ProductInventory {
	private Product product;
	private Long quantity;

	public ProductInventory(Product product, Long quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public void updateQuantity(Long quantity) {
		this.quantity = this.quantity + quantity;
	}

	public boolean isQuantityAvailable(Long quantity) {
		return this.quantity >= quantity;
	}
}
