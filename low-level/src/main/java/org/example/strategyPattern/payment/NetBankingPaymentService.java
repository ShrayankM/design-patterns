package org.example.strategyPattern.payment;

import java.math.BigDecimal;

public class NetBankingPaymentService implements PaymentService {
	@Override
	public void processPayment(BigDecimal amount) {
		System.out.println("Net-banking payment service used to pay-amount = " + amount);
	}
}
