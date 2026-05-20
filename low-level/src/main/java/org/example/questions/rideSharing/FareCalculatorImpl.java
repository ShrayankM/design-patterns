package org.example.questions.rideSharing;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Map;

public class FareCalculatorImpl implements FareCalculator {

	private static final Map<VehicleType, BigDecimal> BASE_FARE = Map.of(
			VehicleType.COMPACT, new BigDecimal("50"),
			VehicleType.SEDAN,   new BigDecimal("80"),
			VehicleType.SUV,     new BigDecimal("120"),
			VehicleType.LUXURY,  new BigDecimal("200")
	);

	private static final Map<VehicleType, BigDecimal> PER_KM_RATE = Map.of(
			VehicleType.COMPACT, new BigDecimal("10"),
			VehicleType.SEDAN,   new BigDecimal("15"),
			VehicleType.SUV,     new BigDecimal("20"),
			VehicleType.LUXURY,  new BigDecimal("30")
	);

	private static final BigDecimal SURGE_MULTIPLIER = new BigDecimal("1.5");

	private final LocationService locationService;

	public FareCalculatorImpl(LocationService locationService) {
		this.locationService = locationService;
	}

	@Override
	public BigDecimal calculateFare(RideRequest rideRequest) {
		VehicleType vehicleType = rideRequest.getVehicleType();
		BigDecimal distance = locationService.calculateTotalDistance(rideRequest);

		BigDecimal baseFare = BASE_FARE.get(vehicleType);
		BigDecimal perKmRate = PER_KM_RATE.get(vehicleType);
		BigDecimal surge = getSurgeMultiplier();

		return baseFare.add(perKmRate.multiply(distance)).multiply(surge);
	}

	private BigDecimal getSurgeMultiplier() {
		int hour = LocalTime.now().getHour();
		boolean isPeakHour = (hour >= 8 && hour <= 10) || (hour >= 17 && hour <= 20);
		return isPeakHour ? SURGE_MULTIPLIER : BigDecimal.ONE;
	}
}