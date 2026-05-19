package org.example.questions.vendingMachine;

import java.math.BigDecimal;

public interface PaymentStrategy {
	void makePayment(BigDecimal amount);
	void refundAmount(BigDecimal amount);
}
