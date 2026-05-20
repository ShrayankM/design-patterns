package org.example.questions.rideSharing;

import java.math.BigDecimal;

public interface FareCalculator {
	BigDecimal calculateFare(RideRequest rideRequest);
}
