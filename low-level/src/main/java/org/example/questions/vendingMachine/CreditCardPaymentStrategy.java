package org.example.questions.vendingMachine;

import java.math.BigDecimal;

public class CreditCardPaymentStrategy implements PaymentStrategy {
	@Override
	public void makePayment(BigDecimal amount) {
		System.out.println("Credit card payment for amount = " + amount);
	}

	@Override
	public void refundAmount(BigDecimal amount) {
		System.out.println("Refund amount using credit-card cashback = " + amount);
	}
}
