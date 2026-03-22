package org.example.atm.state;

import org.example.atm.AtmOperation;
import org.example.atm.AtmSystem;
import org.example.atm.Card;

import java.math.BigDecimal;

public class WithdrawAmountState implements AtmState {
	@Override
	public void insertCard(Card card, AtmSystem atmSystem) {
		throw new IllegalArgumentException("Not supported");
	}

	@Override
	public void insertPin(String pin, AtmSystem atmSystem) {
		throw new IllegalArgumentException("Not supported");
	}

	@Override
	public void chooseOperation(AtmOperation atmOperation, AtmSystem atmSystem) {
		throw new IllegalArgumentException("Not supported");
	}

	@Override
	public void collectAmount(BigDecimal amount, AtmSystem atmSystem) {
		System.out.println("Withdrawing {" + amount + "} amount");
		atmSystem.withdrawOperation(amount);
		atmSystem.setAtmState(new VerifiedState());
	}

	@Override
	public void depositAmount(BigDecimal amount, AtmSystem atmSystem) {
		throw new IllegalArgumentException("Not supported");
	}

	@Override
	public void ejectCard(AtmSystem atmSystem) {
		throw new IllegalArgumentException("Not supported");
	}
}
