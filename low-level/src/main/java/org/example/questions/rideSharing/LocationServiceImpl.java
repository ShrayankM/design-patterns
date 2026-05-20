package org.example.questions.rideSharing;

import java.math.BigDecimal;
import java.util.List;

public class LocationServiceImpl implements LocationService {
	@Override
	public BigDecimal calculateTotalDistance(RideRequest rideRequest) {
		return null;
	}

	@Override
	public List<User> findNearByDrivers(List<User> drivers, Ride ride) {
		return List.of();
	}
}
