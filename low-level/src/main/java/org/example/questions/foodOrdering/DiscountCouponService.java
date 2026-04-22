package org.example.questions.foodOrdering;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DiscountCouponService {
	private Map<String, DiscountCoupon> discountCouponMap;

	public DiscountCouponService() {
		this.discountCouponMap = new HashMap<>();
	}

	public DiscountCoupon getDiscountCouponFromId(String id) {
		return this.discountCouponMap.get(id);
	}

	public DiscountCoupon createDiscountCoupon(DiscountCouponType discountCouponType, DiscountStrategy discountStrategy) {
		DiscountCoupon discountCoupon = new DiscountCoupon(discountCouponType, discountStrategy);
		discountCouponMap.put(discountCoupon.getId(), discountCoupon);
		return discountCoupon;
	}

	public void addDiscountForProducts(Product product, DiscountCoupon discountCoupon) {
		DiscountCoupon currentDiscountCoupon = discountCouponMap.get(discountCoupon.getId());

		if (Objects.nonNull(currentDiscountCoupon)) {
			currentDiscountCoupon.addProductsToDiscountCoupon(product);
			discountCouponMap.put(discountCoupon.getId(), currentDiscountCoupon);
		}
	}
}
