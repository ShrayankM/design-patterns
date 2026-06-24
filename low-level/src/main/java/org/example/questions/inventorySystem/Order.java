package org.example.questions.inventorySystem;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
	private String id;
//	private List<Product> productList;
//	private Long quantity;
	private List<OrderProduct> orderProductList;
	private OrderStatus orderStatus;
	private String warehouseCode;

	public Order(String id, List<OrderProduct> orderProductList) {
		this.id = id;
//		this.productList = productList;
//		this.quantity = quantity;
		this.orderProductList = orderProductList;
		this.orderStatus = OrderStatus.PLACED;
		this.warehouseCode = null;
	}
}
