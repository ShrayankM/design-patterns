package org.example.questions.logistics;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Transport {
	LocalDateTime calculateETA(LogisticOrder logisticOrder);
	BigDecimal calculateCostOfTransport(LogisticOrder logisticOrder);
}
