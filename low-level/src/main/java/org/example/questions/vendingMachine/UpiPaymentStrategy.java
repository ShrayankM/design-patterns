package org.example.questions.vendingMachine;

import java.awt.*;
import java.math.BigDecimal;

public class UpiPaymentStrategy implements PaymentStrategy {
	@Override
	public void makePayment(BigDecimal amount) {
		System.out.println("Upi payment for amount = " + amount);
	}

	@Override
	public void refundAmount(BigDecimal amount) {
		System.out.println("Refund amount using UPI = " + amount);
	}
}
