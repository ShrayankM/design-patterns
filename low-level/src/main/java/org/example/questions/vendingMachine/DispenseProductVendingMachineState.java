package org.example.questions.vendingMachine;

import java.math.BigDecimal;

public class DispenseProductVendingMachineState implements VendingMachineState {
	@Override
	public void chooseProduct(VendingMachine vendingMachine, Product product, Long quantity) {
		System.out.println("Dispensing product, please wait");
	}

	@Override
	public void insertMoney(VendingMachine vendingMachine, BigDecimal amount) {
		System.out.println("Dispensing product, please wait");
	}

	@Override
	public void cancelTransaction(VendingMachine vendingMachine) {
		System.out.println("Cancelling current transaction");
		System.out.println("Returning amount paid = " + vendingMachine.getAmountPaidByCustomer() + " to customer");

		vendingMachine.refund();
		vendingMachine.resetVendingMachineData();
		vendingMachine.setState(new IdleVendingMachineState());
	}

	@Override
	public void dispenseProduct(VendingMachine vendingMachine) {
		Product selectedProduct = vendingMachine.getSelectedProduct();
		Long quantity = vendingMachine.getSelectedProductQuantity();

		vendingMachine.updateInventory(selectedProduct, quantity * -1);
		System.out.println("Dispensing product = " + selectedProduct);

		System.out.println("Returning change to user = " + vendingMachine.getChangeToDispense());
		vendingMachine.resetVendingMachineData();
		vendingMachine.setState(new IdleVendingMachineState());
	}
}
