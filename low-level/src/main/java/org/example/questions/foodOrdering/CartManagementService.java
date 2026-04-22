package org.example.questions.foodOrdering;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartManagementService {
	private Cart currentCart;
	private List<DiscountCoupon> discountCouponList;
	private TaxAndFeesCalculationService taxAndFeesCalculationService;

	public CartManagementService() {
		createCart();
	}

	public void createCart() {
		this.currentCart = new Cart();
		this.discountCouponList = new ArrayList<>();
		this.taxAndFeesCalculationService = new TaxAndFeesCalculationService();
	}

	public void addProductToCart(Product product) {
		if (Objects.nonNull(currentCart)) {
			currentCart.addProductToCart(product);
		}
	}

	public void addCouponToCart(DiscountCoupon discountCoupon) {
		this.discountCouponList.add(discountCoupon);
	}

	public void removeCouponToCart(DiscountCoupon discountCoupon) {
		this.discountCouponList.remove(discountCoupon);
	}

	public void removeProductFromCart(Product product) {
		if (Objects.nonNull(currentCart)) {
			currentCart.removeProductFromCart(product);
		}
	}

	public void increaseProductQuantity(Product product, Integer quantity) {
		if(Objects.nonNull(currentCart)) {
			currentCart.increaseProductQuantity(product, quantity);
		}
	}

	public void decreaseProductQuantity(Product product, Integer quantity) {
		if(Objects.nonNull(currentCart)) {
			currentCart.decreaseProductQuantity(product, quantity);
		}
	}

	public void calculateCartAmount() {
		BigDecimal cartAmount = this.taxAndFeesCalculationService.calculateCartAmount(this.currentCart);
		this.currentCart.setCartAmount(cartAmount);
	}

	public void calculateTaxes() {
		BigDecimal totalTaxAmount = this.taxAndFeesCalculationService.calculateTaxAndFees(this.currentCart);
		this.currentCart.setTotalTaxAmount(totalTaxAmount);
	}

	public void calculateDiscount() {
		BigDecimal cartDiscountAmount = new BigDecimal(0L);
		for (DiscountCoupon discountCoupon : discountCouponList) {
			cartDiscountAmount = cartDiscountAmount.add(discountCoupon.getDiscountStrategy().calculateDiscount(this.currentCart, discountCoupon));
		}

		BigDecimal cartAmount = currentCart.getCartAmount();
		BigDecimal netAmount = cartAmount.add(currentCart.getTotalTaxAmount()).subtract(cartDiscountAmount);

		currentCart.setTotalDiscountAmount(cartDiscountAmount);
		currentCart.setNetAmount(netAmount);
	}

	public void generateOrderSummary() {
		System.out.println("========== ORDER SUMMARY ==========");
		System.out.println("Cart ID: " + currentCart.getId());
		System.out.println("------------------------------------");
		System.out.println("Items:");
		currentCart.getProductQuantityMap().forEach((product, quantity) -> {
			System.out.printf("  %-20s x%d  @ ₹%.2f each%n",
					product.getName(), quantity, product.getPrice());
		});
		System.out.println("------------------------------------");
		System.out.printf("  Cart Amount      : ₹%.2f%n", currentCart.getCartAmount());
		System.out.printf("  Tax              : ₹%.2f%n", currentCart.getTotalTaxAmount());
		System.out.printf("  Discount         : -₹%.2f%n", currentCart.getTotalDiscountAmount());
		System.out.printf("  Net Amount       : ₹%.2f%n", currentCart.getNetAmount());
		System.out.println("====================================");
	}
}
