package org.example.questions.foodOrdering;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

public class PercentageDiscountStrategy implements DiscountStrategy {
	private final BigDecimal percentageDiscount;

	public PercentageDiscountStrategy(BigDecimal percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}

	@Override
	public BigDecimal calculateDiscount(Cart cart, DiscountCoupon discountCoupon) {
		BigDecimal cartDiscountAmount = new BigDecimal(0L);
		if (discountCoupon.getDiscountCouponType().equals(DiscountCouponType.ORDER)) {
			cartDiscountAmount = cart.getCartAmount().multiply(percentageDiscount.divide(BigDecimal.valueOf(100L), RoundingMode.HALF_UP));
		} else if(discountCoupon.getDiscountCouponType().equals(DiscountCouponType.PRODUCT)) {
			Set<Product> productsWithDiscount = discountCoupon.getProductsWithDiscount();
			cartDiscountAmount = new BigDecimal(0L);

			Set<Product> cartProducts = cart.getProductQuantityMap().keySet();
			for (Product cartProduct : cartProducts) {
				if (productsWithDiscount.contains(cartProduct)) {
					cartDiscountAmount = cartDiscountAmount.add(cartProduct.getPrice().multiply(
							percentageDiscount.divide(BigDecimal.valueOf(100L), RoundingMode.HALF_UP)));
				}
			}
		}
		return cartDiscountAmount;
	}
}
