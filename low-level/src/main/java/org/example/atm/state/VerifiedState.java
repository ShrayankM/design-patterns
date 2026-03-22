package org.example.atm.state;

import org.example.atm.AtmOperation;
import org.example.atm.AtmSystem;
import org.example.atm.Card;

import java.math.BigDecimal;

public class VerifiedState implements AtmState {
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
		switch (atmOperation.getOperationType()) {
			case WITHDRAW -> {
				System.out.println("Withdrawing amount");
				atmSystem.setChoosenBankAccount(atmOperation.getBankAccount());
				atmSystem.setAtmState(new WithdrawAmountState());
			}
			case DEPOSIT -> {
				System.out.println("Depositing amount");
				atmSystem.setChoosenBankAccount(atmOperation.getBankAccount());
				atmSystem.setAtmState(new DepositAmountState());
			}
			case EXIT -> {
				System.out.println("Going to card ejection & receipt state");
				atmSystem.setAtmState(new EjectionState());
			}
			default -> {
				System.out.println("Incorrect operation choosen");
			}
		}
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
