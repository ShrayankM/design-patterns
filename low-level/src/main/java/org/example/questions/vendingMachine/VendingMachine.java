package org.example.questions.vendingMachine;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class VendingMachine {
	private InventoryManager inventoryManager;
	private VendingMachineState currentVendingMachineState;
	private Product selectedProduct;
	private Long selectedProductQuantity;
	private BigDecimal amountPaidByCustomer;
	private BigDecimal changeToDispense;
	private PaymentStrategy paymentStrategy;

	public VendingMachine(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
		this.currentVendingMachineState = new IdleVendingMachineState();
		this.changeToDispense = BigDecimal.ZERO;
		this.paymentStrategy = null;
	}

	public boolean checkProductInventoryPresent(Product product, Long quantity) {
		return this.inventoryManager.checkIfInventoryPresent(product, quantity);
	}

	public void setSelectedProduct(Product selectedProduct, Long selectedProductQuantity) {
		this.selectedProduct = selectedProduct;
		this.selectedProductQuantity = selectedProductQuantity;
	}

	public void setState(VendingMachineState vendingMachineState) {
		this.currentVendingMachineState = vendingMachineState;
	}

	public void updateInventory(Product product, Long quantity) {
		this.inventoryManager.updateProductInventory(product, quantity);
	}

	public void resetVendingMachineData() {
		this.paymentStrategy = null;
		this.selectedProduct = null;
		this.selectedProductQuantity = 0L;
		this.amountPaidByCustomer = BigDecimal.ZERO;
		this.changeToDispense = BigDecimal.ZERO;
	}

	// journey
	public void chooseProduct(Product product, Long quantity) {
		this.currentVendingMachineState.chooseProduct(this, product, quantity);
	}

	public void insertMoney(BigDecimal amount) {
		this.currentVendingMachineState.insertMoney(this, amount);
//		dispenseProduct();
	}

	public void dispenseProduct() {
		this.currentVendingMachineState.dispenseProduct(this);
	}

	public void cancelTransaction() {
		 this.currentVendingMachineState.cancelTransaction(this);
	}

	public void completePayment() {
		if (Objects.isNull(this.paymentStrategy)) {
			System.out.println("No payment strategy selected, please select");
			return;
		}
		this.paymentStrategy.makePayment(this.amountPaidByCustomer);
	}

	public void refund() {
		if (Objects.isNull(this.paymentStrategy)) {
			System.out.println("No payment strategy selected, please select");
			return;
		}
		this.paymentStrategy.refundAmount(this.amountPaidByCustomer);
	}
}
