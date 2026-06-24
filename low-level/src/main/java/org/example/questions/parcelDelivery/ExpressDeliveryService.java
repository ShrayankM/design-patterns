package org.example.questions.parcelDelivery;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpressDeliveryService implements DeliveryService {
	@Override
	public LocalDateTime calculateETA(LogisticOrder logisticOrder) {
		return null;
	}

	@Override
	public BigDecimal calculateCostEstimate(LogisticOrder logisticOrder) {
		return null;
	}

	@Override
	public BigDecimal calculateTotalDistance(LogisticOrder logisticOrder) {
		return null;
	}

	@Override
	public boolean isDeliveryServiceAvaiable(LogisticOrder logisticOrder) {
		return false;
	}

	@Override
	public void updateEfficiencyMap(LogisticOrder logisticOrder) {

	}
}
