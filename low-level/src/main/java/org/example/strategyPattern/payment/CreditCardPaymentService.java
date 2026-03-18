package org.example.strategyPattern.payment;

import java.math.BigDecimal;

public class CreditCardPaymentService implements PaymentService {
	@Override
	public void processPayment(BigDecimal amount) {
		System.out.println("Credit-card payment service used to pay-amount = " + amount);
	}
}

