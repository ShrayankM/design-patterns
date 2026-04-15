package org.example.questions.hotelBooking.entities;

import java.math.BigDecimal;

public interface PaymentService {
	void acceptPayment(BigDecimal amount);
	void initiateRefund(BigDecimal amount);
}
