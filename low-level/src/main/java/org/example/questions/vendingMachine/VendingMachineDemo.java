package org.example.questions.vendingMachine;

import java.math.BigDecimal;

public class VendingMachineDemo {
	public static void main(String [] args) {
		InventoryManager inventoryManager = new InventoryManager();

		Product a = new Product("pepsi", ProductType.BEVERAGE, new BigDecimal("3.99"));
		Product b = new Product("lays", ProductType.SNACK, new BigDecimal("4.99"));
		Product c = new Product("powerbank", ProductType.ELECTRONIC, new BigDecimal("15.99"));

		inventoryManager.createProductInventory(a, 5L);
		inventoryManager.createProductInventory(b, 10L);
		inventoryManager.createProductInventory(c, 2L);

		PaymentStrategy upiPaymentStrategy = new UpiPaymentStrategy();
		PaymentStrategy creditCardPaymentStrategy = new CreditCardPaymentStrategy();

		VendingMachine vendingMachine = new VendingMachine(inventoryManager);

		vendingMachine.setPaymentStrategy(upiPaymentStrategy);

		vendingMachine.chooseProduct(a, 2L);
		vendingMachine.insertMoney(new BigDecimal("10.00"));
		vendingMachine.dispenseProduct();

		vendingMachine.setPaymentStrategy(upiPaymentStrategy);

		vendingMachine.chooseProduct(a, 2L);
		vendingMachine.insertMoney(new BigDecimal("6.00"));
		vendingMachine.insertMoney(new BigDecimal("10.00"));
		vendingMachine.cancelTransaction();
		vendingMachine.dispenseProduct();

		vendingMachine.setPaymentStrategy(upiPaymentStrategy);

		vendingMachine.chooseProduct(a, 2L);
		vendingMachine.insertMoney(new BigDecimal("10.00"));
		vendingMachine.dispenseProduct();
	}
}
