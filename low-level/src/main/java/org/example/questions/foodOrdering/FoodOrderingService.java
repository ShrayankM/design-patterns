package org.example.questions.foodOrdering;

public class FoodOrderingService {
	private MenuService menuService;
	private CartManagementService cartManagementService;
	private DiscountCouponService discountCouponService;

	public FoodOrderingService(MenuService menuService, DiscountCouponService discountCouponService) {
		this.menuService = menuService;
		this.cartManagementService = new CartManagementService();
		this.discountCouponService = discountCouponService;
	}

	public void addProductToCart(String productId) {
		Product product = this.menuService.getProductFromMenu(productId);
		this.cartManagementService.addProductToCart(product);
	}

	public void updateQuantity(String productId, Integer quantity) {
		Product product = this.menuService.getProductFromMenu(productId);
		if (quantity > 0) {
			this.cartManagementService.increaseProductQuantity(product, quantity);
		} else {
			this.cartManagementService.decreaseProductQuantity(product, quantity);
		}
	}

	public void addDiscountCoupon(String couponId) {
		DiscountCoupon discountCoupon = this.discountCouponService.getDiscountCouponFromId(couponId);
		this.cartManagementService.addCouponToCart(discountCoupon);
	}

	public void removeDiscountCoupon(String couponId) {
		DiscountCoupon discountCoupon = this.discountCouponService.getDiscountCouponFromId(couponId);
		this.cartManagementService.removeCouponToCart(discountCoupon);
	}

	public void checkout() {
		this.cartManagementService.calculateCartAmount();
		this.cartManagementService.calculateTaxes();
		this.cartManagementService.calculateDiscount();
		this.cartManagementService.generateOrderSummary();
	}
}
