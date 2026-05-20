package org.example.questions.rideSharing;

import java.math.BigDecimal;
import java.util.List;

public interface LocationService {
	BigDecimal calculateTotalDistance(RideRequest rideRequest);

	List<User> findNearByDrivers(List<User> drivers, Ride ride);
}
