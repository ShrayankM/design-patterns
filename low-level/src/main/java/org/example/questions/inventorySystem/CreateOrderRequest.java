package org.example.questions.inventorySystem;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
	private String orderId;
	private List<ProductRequest> productRequestList;

	public CreateOrderRequest(String orderId, List<ProductRequest> productRequestList) {
		this.orderId = orderId;
		this.productRequestList = productRequestList;
	}
}
