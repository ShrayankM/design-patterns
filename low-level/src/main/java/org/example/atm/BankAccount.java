package org.example.atm;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
public class BankAccount {
	private String bankAccountNumber;
	private BigDecimal balance;
	private Map<String, Card> cardMap;

	public BankAccount(String bankAccountNumber, BigDecimal balance) {
		this.bankAccountNumber = bankAccountNumber;
		this.balance = balance;
		this.cardMap = new HashMap<>();
	}

	public void addCardToBankAccount(Card card) {
		cardMap.put(card.getCardNumber(), card);
	}

	public void deposit(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		if (this.balance.compareTo(amount) < 0) {
			System.out.println("Insufficient balance");
		} else {
			this.balance = this.balance.subtract(amount);
		}
	}
}
