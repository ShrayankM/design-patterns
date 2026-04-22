package org.example.questions.foodOrdering;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MenuService {
	private Map<String, Product> productMap;

	public MenuService() {
		this.productMap = new HashMap<>();
	}

	public Product getProductFromMenu(String productId) {
		return this.productMap.get(productId);
	}

	public void addProductToMenu(Product product) {
		this.productMap.put(product.getId(), product);
	}

	public void removeProductFromMenu(Product product) {
		this.productMap.remove(product.getId(), product);
	}

	public void updateProductPrice(Product product, BigDecimal price) {
		if (this.productMap.get(product.getId()) != null) {
			Product currentProduct = this.productMap.get(product.getId());
			currentProduct.setPrice(price);
			this.productMap.put(product.getId(), currentProduct);
		}
	}

	public void updateProductTax(Product product, ProductTax productTax) {
		if (this.productMap.get(product.getId()) != null) {
			Product currentProduct = this.productMap.get(product.getId());
			currentProduct.setProductTax(productTax);
			this.productMap.put(product.getId(), currentProduct);
		}
	}
}
