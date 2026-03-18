package org.example.strategyPattern.payment;

import java.math.BigDecimal;

public class StrategyDemo {
	public static void main(String [] args) {
		BigDecimal amountToBePaid = new BigDecimal("100.99");
		PaymentProcessor paymentProcessor = new PaymentProcessor(new CreditCardPaymentService());
		paymentProcessor.acceptPayment(amountToBePaid);

		paymentProcessor.setPaymentService(new UpiPaymentService());
		paymentProcessor.acceptPayment(new BigDecimal("59.99"));
	}
}
