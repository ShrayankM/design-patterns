package org.example.questions.logistics;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AirTransport implements Transport {
	@Override
	public LocalDateTime calculateETA(LogisticOrder logisticOrder) {
		return null;
	}

	@Override
	public BigDecimal calculateCostOfTransport(LogisticOrder logisticOrder) {
		return null;
	}
}
