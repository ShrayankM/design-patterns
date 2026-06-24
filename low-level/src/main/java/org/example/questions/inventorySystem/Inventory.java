package org.example.questions.inventorySystem;

import lombok.Getter;

@Getter
public class Inventory {
	private String productCode;
	private Product product;
	private Long availableQuantity;
	private Long reservedQuantity;

	public Inventory(Product product, Long availableQuantity) {
		this.product = product;
		this.availableQuantity = availableQuantity;
		this.productCode = product.getCode();
		this.reservedQuantity = 0L;
	}

	public synchronized void addQuantity(Long quantity) {
		if (quantity <= 0) {
			System.out.println("Quantity is less than or equal to zero");
			return;
		}
		this.availableQuantity = this.availableQuantity + quantity;
	}

	public synchronized void reserveQuantity(Long quantity) {
		if (availableQuantity >= quantity) {
			this.reservedQuantity = this.reservedQuantity + quantity;
			this.availableQuantity = this.availableQuantity - quantity;
		} else {
			System.out.println("Cannot reserve quantity");
		}
	}

	public synchronized void releaseReserveQuantity(Long quantity, boolean markAsCancelled) {
		this.reservedQuantity = this.reservedQuantity - quantity;
		if (markAsCancelled) {
			this.availableQuantity = this.availableQuantity + quantity;
		}
	}
}
