package org.example.questions.library;

import java.math.BigDecimal;

public class FineCalculator {
	private final BigDecimal amountPerDayOverDue;

	public FineCalculator(BigDecimal amountPerDayOverDue) {
		this.amountPerDayOverDue = amountPerDayOverDue;
	}

	public BigDecimal calculateFine(int overDueDays) {
		return amountPerDayOverDue.multiply(BigDecimal.valueOf(overDueDays));
	}
}
