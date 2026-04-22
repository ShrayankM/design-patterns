package org.example.questions.foodOrdering;

import java.math.BigDecimal;
import java.util.Set;

public class FlatDiscountStrategy implements DiscountStrategy {
	private final BigDecimal flatDiscount;

	public FlatDiscountStrategy(BigDecimal flatDiscount) {
		this.flatDiscount = flatDiscount;
	}

	@Override
	public BigDecimal calculateDiscount(Cart cart, DiscountCoupon discountCoupon) {
		BigDecimal cartDiscountAmount = new BigDecimal(0L);
		if (discountCoupon.getDiscountCouponType().equals(DiscountCouponType.ORDER)) {
			cartDiscountAmount = flatDiscount;
		} else if(discountCoupon.getDiscountCouponType().equals(DiscountCouponType.PRODUCT)) {
			Set<Product> productsWithDiscount = discountCoupon.getProductsWithDiscount();
			cartDiscountAmount = new BigDecimal(0L);

			Set<Product> cartProducts = cart.getProductQuantityMap().keySet();
			for (Product cartProduct : cartProducts) {
				if (productsWithDiscount.contains(cartProduct)) {
					cartDiscountAmount = cartDiscountAmount.add(flatDiscount);
				}
			}
		}
		return cartDiscountAmount;
	}
}
