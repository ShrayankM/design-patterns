package org.example.questions.foodOrdering;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class TaxAndFeesCalculationService {
	public BigDecimal calculateTaxAndFees(Cart cart) {

		BigDecimal[] totalTaxAmount = { BigDecimal.ZERO };
		cart.getProductQuantityMap().forEach((cartProduct, quantity) -> {
			ProductTax productTax = cartProduct.getProductTax();
			totalTaxAmount[0] = totalTaxAmount[0].add(cartProduct.getPrice().multiply(BigDecimal.valueOf(quantity).multiply(
					productTax.getPercentageTax().divide(BigDecimal.valueOf(100L), RoundingMode.HALF_UP))));
		});

		cart.setTotalTaxAmount(totalTaxAmount[0]);
		return totalTaxAmount[0];
	}

	public BigDecimal calculateCartAmount(Cart cart) {
		BigDecimal[] cartAmount = { BigDecimal.ZERO };
		cart.getProductQuantityMap().forEach((cartProduct, quantity) -> {
			cartAmount[0] = cartAmount[0].add(cartProduct.getPrice().multiply(BigDecimal.valueOf(quantity)));
		});
		cart.setCartAmount(cartAmount[0]);
		return cartAmount[0];
	}
}
