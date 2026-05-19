package org.example.questions.vendingMachine;

import java.math.BigDecimal;

public interface VendingMachineState {
	void chooseProduct(VendingMachine vendingMachine, Product product, Long quantity);
	void insertMoney(VendingMachine vendingMachine, BigDecimal amount);
	void cancelTransaction(VendingMachine vendingMachine);
	void dispenseProduct(VendingMachine vendingMachine);
}
