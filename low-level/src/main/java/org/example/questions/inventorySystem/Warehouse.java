package org.example.questions.inventorySystem;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Warehouse {
	@Getter
	private String warehouseCode;
	private Map<String, Inventory> inventoryMap;

	@Getter
	@Setter
	private WarehouseStatus status;

	public Warehouse(String warehouseCode, Map<String, Inventory> inventoryMap, WarehouseStatus warehouseStatus) {
		this.warehouseCode = warehouseCode;
		this.inventoryMap = inventoryMap;
		this.status = warehouseStatus;
	}

	public void addProductsToWarehouse(List<UpdateInventoryRequest> updateInventoryRequestList) {
		for (UpdateInventoryRequest updateInventoryRequest : updateInventoryRequestList) {
			Product product = updateInventoryRequest.getProduct();
			Inventory inventory = inventoryMap.get(product.getCode());
			if (Objects.isNull(inventory)) {
				Inventory newInventory = new Inventory(product, updateInventoryRequest.getQuantity());
				inventoryMap.put(product.getCode(), newInventory);
			} else {
				inventory.addQuantity(updateInventoryRequest.getQuantity());
			}
		}
	}

	public boolean checkProductAvaliability(Order order) {
		List<OrderProduct> orderProductList = order.getOrderProductList();
		for (OrderProduct orderProduct : orderProductList) {
			Inventory inventory = inventoryMap.get(orderProduct.getProduct().getCode());
			if (Objects.isNull(inventory)) {
				System.out.println("Product inventory not found");
				return false;
			}
			if (inventory.getAvailableQuantity() < orderProduct.getQuantity()) {
				return false;
			}
		}
		return true;
	}

	public synchronized void packProductForDelivery(Order order) {
		boolean isAvailable = checkProductAvaliability(order);
		if (!isAvailable) {
			System.out.println("Inventory for order is not avaliable");
			return;
		}

		List<OrderProduct> orderProductList = order.getOrderProductList();
		for (OrderProduct orderProduct : orderProductList) {
			Inventory inventory = inventoryMap.get(orderProduct.getProduct().getCode());
			inventory.reserveQuantity(orderProduct.getQuantity());
			System.out.println("Product = " + orderProduct.getProduct().getCode() + " packed for pickup at warehouse");
		}
	}

	public void productDelivered(Order order) {
		List<OrderProduct> orderProductList = order.getOrderProductList();
		for (OrderProduct orderProduct : orderProductList) {
			Inventory inventory = inventoryMap.get(orderProduct.getProduct().getCode());
			inventory.releaseReserveQuantity(orderProduct.getQuantity(), false);
		}
	}

	public void productReturned(Order order) {
		List<OrderProduct> orderProductList = order.getOrderProductList();
		for (OrderProduct orderProduct : orderProductList) {
			Inventory inventory = inventoryMap.get(orderProduct.getProduct().getCode());
			if (Objects.isNull(inventory)) {
				System.out.println("Product inventory not found");
				return;
			}
			inventory.releaseReserveQuantity(orderProduct.getQuantity(), true);
		}
	}
}
