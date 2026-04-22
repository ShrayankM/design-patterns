package org.example.questions.foodOrdering;

import lombok.Data;

@Data
public class CartItem {
	private Product product;
	private Integer quantity;

	public CartItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}
}
