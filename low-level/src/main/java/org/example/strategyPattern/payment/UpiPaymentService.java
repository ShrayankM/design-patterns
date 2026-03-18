package org.example.strategyPattern.payment;

import java.math.BigDecimal;

public class UpiPaymentService implements PaymentService {
	@Override
	public void processPayment(BigDecimal amount) {
		System.out.println("UPI payment service used to pay-amount = " + amount);
	}
}
