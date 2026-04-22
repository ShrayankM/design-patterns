package org.example.questions.foodOrdering;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class Cart {
	private String id;
	private Map<Product, Integer> productQuantityMap;
	private BigDecimal cartAmount;
	private BigDecimal totalTaxAmount;
	private BigDecimal netAmount;
	private BigDecimal totalDiscountAmount;

	public Cart() {
		this.id = UUID.randomUUID().toString();
		this.productQuantityMap = new HashMap<>();
		this.cartAmount = BigDecimal.valueOf(0L);
		this.netAmount = BigDecimal.valueOf(0L);
		this.totalDiscountAmount = BigDecimal.valueOf(0L);
		this.totalTaxAmount = BigDecimal.valueOf(0L);
	}

	public void addProductToCart(Product product) {
		productQuantityMap.put(product, 1);
	}

	public void removeProductFromCart(Product product) {
		productQuantityMap.remove(product);
	}

	public void increaseProductQuantity(Product product, Integer quantity) {
		productQuantityMap.put(product, productQuantityMap.get(product) + quantity);
	}

	public void decreaseProductQuantity(Product product, Integer quantity) {
		Integer currentQuantity = productQuantityMap.get(product);
		if (currentQuantity - quantity <= 0) {
			productQuantityMap.remove(product);
		} else {
			productQuantityMap.put(product, currentQuantity - quantity);
		}
	}
}
