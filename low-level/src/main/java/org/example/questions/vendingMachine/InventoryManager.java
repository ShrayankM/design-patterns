package org.example.questions.vendingMachine;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class InventoryManager {
	private Map<String, ProductInventory> productInventoryMap;

	public InventoryManager() {
		this.productInventoryMap = new HashMap<>();
	}

	public void createProductInventory(Product product, Long quantity) {
		ProductInventory productInventory = new ProductInventory(product, quantity);
		String productId = product.getId();

		if (productInventoryMap.get(productId) != null) {
			System.out.println("Product inventory already present cannot create new inventory");
			return;
		}
		this.productInventoryMap.put(productId, productInventory);
	}

	public void updateProductInventory(Product product, Long quantity) {
		String productId = product.getId();
		ProductInventory productInventory = this.productInventoryMap.get(productId);

		if (Objects.isNull(productInventory)) {
			System.out.println("Product inventory not found, please create new inventory");
			return;
		}

		if (quantity == 0) return;

		if (quantity > productInventory.getQuantity()) {
			System.out.println("Insufficient quantity available, cannot update inventory");
			return;
		}

		productInventory.updateQuantity(quantity);
	}

	public boolean checkIfInventoryPresent(Product product, Long quantity) {
		String productId = product.getId();
		ProductInventory productInventory = this.productInventoryMap.get(productId);

		if (Objects.isNull(productInventory)) {
			System.out.println("Product inventory not found");
			return false;
		}

		if (quantity < 0) {
			System.out.println("Negative quantity entered");
			return false;
		}
		return productInventory.isQuantityAvailable(quantity);
	}
}
