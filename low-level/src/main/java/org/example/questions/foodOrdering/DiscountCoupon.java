package org.example.questions.foodOrdering;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class DiscountCoupon {
	private final String id;
	private final DiscountCouponType discountCouponType;
	private Set<Product> productsWithDiscount;
	private final DiscountStrategy discountStrategy;

	public DiscountCoupon(DiscountCouponType discountCouponType, DiscountStrategy discountStrategy) {
		this.id = UUID.randomUUID().toString();
		this.discountCouponType = discountCouponType;
		this.discountStrategy = discountStrategy;
		this.productsWithDiscount = new HashSet<>();
	}

	public void addProductsToDiscountCoupon(Product product) {
		this.productsWithDiscount.add(product);
	}
}
