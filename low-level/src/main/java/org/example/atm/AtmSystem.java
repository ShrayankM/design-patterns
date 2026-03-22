package org.example.atm;

import lombok.Setter;
import org.example.atm.noteDispenser.NoteDispenser10;
import org.example.atm.noteDispenser.NoteDispenser100;
import org.example.atm.noteDispenser.NoteDispenser20;
import org.example.atm.noteDispenser.NoteDispenser500;
import org.example.atm.noteDispenser.NoteDispenserImpl;
import org.example.atm.state.AtmState;
import org.example.atm.state.IdleState;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Setter
public class AtmSystem {
	private AtmState atmState;
	private Card currentCard;
	private BankAccount choosenBankAccount;
	private final NoteDispenserImpl cashDispenser;
	private BankingSystem bankingSystem;

	public AtmSystem(BankingSystem bankingSystem) {
		this.atmState = new IdleState();
		this.currentCard = null;
		this.bankingSystem = bankingSystem;
		this.choosenBankAccount = null;

		NoteDispenser500 noteDispenser500 = new NoteDispenser500(new BigDecimal("500.0"), 2);
		NoteDispenser100 noteDispenser100 = new NoteDispenser100(new BigDecimal("100.0"), 3);
		NoteDispenser20 noteDispenser20 = new NoteDispenser20(new BigDecimal("20.0"), 5);
		NoteDispenser10 noteDispenser10 = new NoteDispenser10(new BigDecimal("10.0"), 10);

		this.cashDispenser = noteDispenser500;
		noteDispenser500.addNext(noteDispenser100);
		noteDispenser100.addNext(noteDispenser20);
		noteDispenser20.addNext(noteDispenser10);
	}

	public boolean verifyPinForCard(String pin) {
		return this.bankingSystem.verifyPinForCard(this.currentCard, pin);
	}

	public void withdrawOperation(BigDecimal amount) {
		List<BankAccount> bankAccounts = this.bankingSystem.getBankAccountsForCard(this.currentCard);
		Map<String, BankAccount> bankAccountMap = bankAccounts.stream()
				.collect(Collectors.toMap(BankAccount::getBankAccountNumber, Function.identity()));

		if (this.cashDispenser.check(amount)) {
			this.cashDispenser.dispense(amount);
			this.bankingSystem.withdrawMoneyFromAccount(
					bankAccountMap.get(this.choosenBankAccount.getBankAccountNumber()), amount);
		} else {
			System.out.println("Cash dispenser does not have enough amount");
		}
	}

	public void depositOperation(BigDecimal amount) {
		List<BankAccount> bankAccounts = this.bankingSystem.getBankAccountsForCard(this.currentCard);
		Map<String, BankAccount> bankAccountMap = bankAccounts.stream()
				.collect(Collectors.toMap(BankAccount::getBankAccountNumber, Function.identity()));

		this.bankingSystem.depositMoneyToAccount(
				bankAccountMap.get(this.choosenBankAccount.getBankAccountNumber()), amount);
	}

	public void resetMachine() {
		this.currentCard = null;
		this.choosenBankAccount = null;
	}

	public void insertCard(Card card) {
		this.atmState.insertCard(card, this);
	}

	public void enterPin(String pin) {
		this.atmState.insertPin(pin, this);
	}

	public void chooseOperation(AtmOperation atmOperation) {
		this.atmState.chooseOperation(atmOperation, this);
	}

	public void collectCash(BigDecimal amount) {
		this.atmState.collectAmount(amount, this);
	}
}
