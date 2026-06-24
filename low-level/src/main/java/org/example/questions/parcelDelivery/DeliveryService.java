package org.example.questions.parcelDelivery;


import org.example.questions.logging.Log;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DeliveryService {
	LocalDateTime calculateETA(LogisticOrder logisticOrder);
	BigDecimal calculateCostEstimate(LogisticOrder logisticOrder);
	BigDecimal calculateTotalDistance(LogisticOrder logisticOrder);
	boolean isDeliveryServiceAvaiable(LogisticOrder logisticOrder);
	void updateEfficiencyMap(LogisticOrder logisticOrder);
}
