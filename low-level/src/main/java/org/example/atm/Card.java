package org.example.atm;

import lombok.Getter;

@Getter
public class Card {
	private final String cardNumber;
	private final String pin;

	public Card(String cardNumber, String pin) {
		this.cardNumber = cardNumber;
		this.pin = pin;
	}

	public boolean verifyPin(String pin) {
		return this.pin.equals(pin);
	}
}
