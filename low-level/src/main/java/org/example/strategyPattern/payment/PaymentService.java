package org.example.strategyPattern.payment;

import java.math.BigDecimal;

public interface PaymentService {
	void processPayment(BigDecimal amount);
}
