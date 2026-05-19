package org.example.questions.vendingMachine;

import java.math.BigDecimal;

public class IdleVendingMachineState implements VendingMachineState {

	@Override
	public void chooseProduct(VendingMachine vendingMachine, Product product, Long quantity) {
		if (vendingMachine.checkProductInventoryPresent(product, quantity)) {
			vendingMachine.setSelectedProduct(product, quantity);
			vendingMachine.setState(new ProductSelectedVendingMachineState());
		} else {
			System.out.println("Selected product quantity not available, please choose different product");
		}
	}

	@Override
	public void insertMoney(VendingMachine vendingMachine, BigDecimal amount) {
		System.out.println("Please choose product first");
	}

	@Override
	public void cancelTransaction(VendingMachine vendingMachine) {
		System.out.println("Cannot cancel as no transaction is present");
	}

	@Override
	public void dispenseProduct(VendingMachine vendingMachine) {
		System.out.println("Please choose product first");
	}
}
