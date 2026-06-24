package org.example.questions.inventorySystem;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WarehouseManager {
	private Map<String, Warehouse> warehouseMap;

	public WarehouseManager(Map<String, Warehouse> warehouseMap) {
		this.warehouseMap = warehouseMap;
	}

	public void updateInventoryForWarehouse(String warehouseCode, List<UpdateInventoryRequest> updateInventoryRequestList) {
		Warehouse warehouse = this.warehouseMap.get(warehouseCode);
		if (Objects.isNull(warehouse)) {
			System.out.println("Warehouse not found in map");
			return;
		}

		if (WarehouseStatus.CLOSED.equals(warehouse.getStatus())) {
			System.out.println("Warehouse is not operational cannot update inventory");
			return;
		}
		warehouse.addProductsToWarehouse(updateInventoryRequestList);
	}

	public void updateWarehouseStatus(String warehouseCode, WarehouseStatus warehouseStatus) {
		Warehouse warehouse = this.warehouseMap.get(warehouseCode);
		if (Objects.isNull(warehouse)) {
			System.out.println("Warehouse not found in map");
			return;
		}
		warehouse.setStatus(warehouseStatus);
	}

	public Warehouse findWarehouseForOrder(Order order) {
		List<Warehouse> warehouseList = warehouseMap.values().stream()
				.filter(warehouse -> WarehouseStatus.OPERATIONAL.equals(warehouse.getStatus()))
				.toList();
		if (warehouseList.isEmpty()) {
			System.out.println("No operational warehouse found");
		}

		for (Warehouse warehouse : warehouseList) {
			boolean isAvailable = warehouse.checkProductAvaliability(order);
			if (isAvailable) return warehouse;
		}
		System.out.println("No");
		return null;
	}

	public void updateWarehouseForOrderDelivered(Order order, String warehouseCode) {
		Warehouse warehouse = this.warehouseMap.get(warehouseCode);
		if (Objects.isNull(warehouse)) {
			System.out.println("Warehouse not found in map");
			return;
		}
		warehouse.productDelivered(order);
	}

	public void updateWarehouseForOrderCancelled(Order order, String warehouseCode) {
		Warehouse warehouse = this.warehouseMap.get(warehouseCode);
		if (Objects.isNull(warehouse)) {
			System.out.println("Warehouse not found in map");
			return;
		}
		warehouse.productReturned(order);
	}
}
