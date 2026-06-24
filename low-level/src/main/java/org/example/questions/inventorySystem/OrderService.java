package org.example.questions.inventorySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrderService {
	private Map<String, Order> orderMap;
	private WarehouseManager warehouseManager;

	public OrderService(Map<String, Order> orderMap, WarehouseManager warehouseManager) {
		this.orderMap = orderMap;
		this.warehouseManager = warehouseManager;
	}

	public void createOrder(CreateOrderRequest createOrderRequest) {
		List<ProductRequest> productRequestList = createOrderRequest.getProductRequestList();
		List<OrderProduct> orderProductList = new ArrayList<>();

		for (ProductRequest productRequest : productRequestList) {
			OrderProduct orderProduct = new OrderProduct(productRequest.getProduct(), productRequest.getQuantity());
			orderProductList.add(orderProduct);
		}

		Order order = new Order(createOrderRequest.getOrderId(), orderProductList);
		Warehouse warehouse = warehouseManager.findWarehouseForOrder(order);
		order.setWarehouseCode(warehouse.getWarehouseCode());
		this.orderMap.put(order.getId(), order);
		warehouse.packProductForDelivery(order);
		System.out.println("Order is placed, successfully will be dispatched shortly");
	}

	public void markOrderAsPicked(String orderId) {
		Order order = this.orderMap.get(orderId);
		if (Objects.isNull(order)) {
			System.out.println("Order not found");
			return;
		}
		order.setOrderStatus(OrderStatus.PICKED_UP);
	}

	public void markOrderAsDelivered(String orderId) {
		Order order = this.orderMap.get(orderId);
		if (Objects.isNull(order)) {
			System.out.println("Order not found");
			return;
		}

		order.setOrderStatus(OrderStatus.DELIVERED);
		String warehouseCode = order.getWarehouseCode();
		warehouseManager.updateWarehouseForOrderDelivered(order, warehouseCode);
	}

	public void markOrderAsReturned(String orderId) {
		Order order = this.orderMap.get(orderId);
		if (Objects.isNull(order)) {
			System.out.println("Order not found");
			return;
		}

		order.setOrderStatus(OrderStatus.CANCELLED);
		String warehouseCode = order.getWarehouseCode();
		warehouseManager.updateWarehouseForOrderCancelled(order, warehouseCode);
	}
}
