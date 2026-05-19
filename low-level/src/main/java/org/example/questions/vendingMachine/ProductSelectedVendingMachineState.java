package org.example.questions.vendingMachine;

import java.math.BigDecimal;

public class ProductSelectedVendingMachineState implements VendingMachineState {
	@Override
	public void chooseProduct(VendingMachine vendingMachine, Product product, Long quantity) {
		System.out.println("Product already selected, please insert money");
	}

	@Override
	public void insertMoney(VendingMachine vendingMachine, BigDecimal amount) {
		Product selectedProduct = vendingMachine.getSelectedProduct();
		Long quantity = vendingMachine.getSelectedProductQuantity();

		BigDecimal totalToPay = selectedProduct.getProductPrice().multiply(BigDecimal.valueOf(quantity));
		if (totalToPay.compareTo(amount) > 0) {
			System.out.println("Please enter correct amount, amount to be paid = " + totalToPay);
			return;
		}

		vendingMachine.setAmountPaidByCustomer(amount);
		vendingMachine.completePayment();
		vendingMachine.setChangeToDispense(amount.subtract(totalToPay));
		vendingMachine.setState(new DispenseProductVendingMachineState());
	}

	@Override
	public void cancelTransaction(VendingMachine vendingMachine) {
		System.out.println("Cancelling current transaction");
		vendingMachine.resetVendingMachineData();
		vendingMachine.setState(new IdleVendingMachineState());
	}

	@Override
	public void dispenseProduct(VendingMachine vendingMachine) {
		System.out.println("Cannot dispense product, please insert money");
	}
}
