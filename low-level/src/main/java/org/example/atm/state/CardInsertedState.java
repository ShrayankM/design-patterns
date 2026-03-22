package org.example.atm.state;

import org.example.atm.AtmOperation;
import org.example.atm.AtmSystem;
import org.example.atm.Card;

import java.math.BigDecimal;

public class CardInsertedState implements AtmState {
	@Override
	public void insertCard(Card card, AtmSystem atmSystem) {
		throw new IllegalArgumentException("Not supported");
	}

	@Override
	public void insertPin(String pin, AtmSystem atmSystem) {
		if(atmSystem.verifyPinForCard(pin)) {
			System.out.println("Card is verified");
			atmSystem.setAtmState(new VerifiedState());
			return;
		}
		System.out.println("Invalid pin entered");
	}

	@Override
	public void chooseOperation(AtmOperation atmOperation, AtmSystem atmSystem) {
		throw new IllegalArgumentException("Not supported");
	}

	@Override
	public void collectAmount(BigDecimal amount, AtmSystem atmSystem) {
		throw new IllegalArgumentException("Not supported");
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
