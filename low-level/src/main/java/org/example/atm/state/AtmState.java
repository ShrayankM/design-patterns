package org.example.atm.state;

import org.example.atm.AtmOperation;
import org.example.atm.AtmSystem;
import org.example.atm.Card;

import java.math.BigDecimal;

public interface AtmState {
	void insertCard(Card card, AtmSystem atmSystem);
	void insertPin(String pin, AtmSystem atmSystem);
	void chooseOperation(AtmOperation atmOperation, AtmSystem atmSystem);
	void collectAmount(BigDecimal amount, AtmSystem atmSystem);
	void depositAmount(BigDecimal amount, AtmSystem atmSystem);
	void ejectCard(AtmSystem atmSystem);
}
