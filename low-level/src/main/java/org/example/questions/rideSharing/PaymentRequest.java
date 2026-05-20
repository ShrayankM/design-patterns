package org.example.questions.rideSharing;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
	private String id;
	private BigDecimal totalFare;
	private String payeeId;
}
