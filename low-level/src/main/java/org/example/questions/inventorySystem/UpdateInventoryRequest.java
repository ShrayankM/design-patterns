package org.example.questions.inventorySystem;

import lombok.Getter;

@Getter
public class UpdateInventoryRequest {
	private final Product product;
	private final Long quantity;

	public UpdateInventoryRequest(Product product, Long quantity) {
		this.product = product;
		this.quantity = quantity;
	}
}
