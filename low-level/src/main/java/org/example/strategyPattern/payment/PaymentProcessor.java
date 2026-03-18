package org.example.strategyPattern.payment;

import java.math.BigDecimal;

public class PaymentProcessor {
	private PaymentService paymentService;

	public PaymentProcessor(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void acceptPayment(BigDecimal amount) {
		this.paymentService.processPayment(amount);
	}
}
