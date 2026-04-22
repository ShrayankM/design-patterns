package org.example.questions.foodOrdering;

import java.math.BigDecimal;

public interface DiscountStrategy {
	BigDecimal calculateDiscount(Cart cart, DiscountCoupon discountCoupon);
}
