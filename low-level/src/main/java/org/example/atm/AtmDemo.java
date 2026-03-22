package org.example.atm;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AtmDemo {
	public static void main(String [] args) {
		Map<String, BankAccount> bankAccountMap = new HashMap<>();

		BankAccount b1 = new BankAccount("B101", new BigDecimal("2560"));
		BankAccount b2 = new BankAccount("B102", new BigDecimal("95"));

		Card c1 = new Card("c101", "9011");
		Card c2 = new Card("c102", "8011");

		b1.addCardToBankAccount(c1);
		b2.addCardToBankAccount(c2);

		bankAccountMap.put(b1.getBankAccountNumber(), b1);
		bankAccountMap.put(b2.getBankAccountNumber(), b2);

		BankingSystem bankingSystem = new BankingSystem(bankAccountMap);
		AtmSystem atmSystem = new AtmSystem(bankingSystem);

		// insert card
		atmSystem.insertCard(c1);

		// enter pin
		atmSystem.enterPin("9011");

		// choose operation
		atmSystem.chooseOperation(new AtmOperation(OperationType.WITHDRAW, b1));

		// enter cash to collect
		atmSystem.collectCash(new BigDecimal("560"));

		// exit
		atmSystem.chooseOperation(new AtmOperation(OperationType.EXIT, null));
	}
}
