package org.example.atm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingSystem {
	private Map<String, BankAccount> bankAccountMap;
	private Map<String, List<BankAccount>> cardToBankAccountMap;

	public BankingSystem(Map<String, BankAccount> bankAccountMap) {
		this.bankAccountMap = bankAccountMap;
		this.cardToBankAccountMap = new HashMap<>();

		bankAccountMap.forEach((accountNumber, bankAccount) -> {
			Map<String, Card> cardMap = bankAccount.getCardMap();

			cardMap.forEach((cardNumber, card) -> {
				List<BankAccount> accounts = cardToBankAccountMap.getOrDefault(cardNumber, new ArrayList<>());
				accounts.add(bankAccount);
				cardToBankAccountMap.put(cardNumber, accounts);
			});
		});
	}

	public void withdrawMoneyFromAccount(BankAccount bankAccount, BigDecimal amount) {
		bankAccount.withdraw(amount);
	}

	public void depositMoneyToAccount(BankAccount bankAccount, BigDecimal amount) {
		bankAccount.deposit(amount);
	}

	public List<BankAccount> getBankAccountsForCard(Card card) {
		return this.cardToBankAccountMap.get(card.getCardNumber());
	}

	public boolean verifyPinForCard(Card card, String pin) {
		return card.verifyPin(pin);
	}

	public void linkCardToBankAccount(BankAccount bankAccount, Card card) {
		bankAccount.addCardToBankAccount(card);

		List<BankAccount> accounts = cardToBankAccountMap.getOrDefault(card.getCardNumber(), new ArrayList<>());
		accounts.add(bankAccount);
		cardToBankAccountMap.put(card.getCardNumber(), accounts);
	}
}
