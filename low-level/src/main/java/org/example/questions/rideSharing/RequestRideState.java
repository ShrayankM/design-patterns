package org.example.questions.rideSharing;

import java.math.BigDecimal;

public class RequestRideState implements RideState {
	private final LocationService locationService;
	private final FareCalculator fareCalculator;

	public RequestRideState(LocationService locationService, FareCalculator fareCalculator) {
		this.locationService = locationService;
		this.fareCalculator = fareCalculator;
	}

	@Override
	public Ride requestRide(RideManager rideManager, RideRequest rideRequest) {
		Ride ride = new Ride(rideRequest);
		BigDecimal estimatedDistance = locationService.calculateTotalDistance(rideRequest);
		BigDecimal estimatedFare = fareCalculator.calculateFare(rideRequest);

		ride.setEstimatedDistance(estimatedDistance);
		ride.setEstimatedFare(estimatedFare);
		ride.setRideStatus(RideStatus.REQUESTED);

		// this will be async
		rideManager.notifyNearByRiders(ride);
		rideManager.updateRideMap(ride.getId(), ride);
//		this.rideMap.put(ride.getId(), ride);
		rideManager.updateRideState(ride.getId(), new AcceptedRideState());
		return ride;
	}

	@Override
	public void acceptRide(RideManager rideManager, User driver, String rideId) {

	}

	@Override
	public void startRide(RideManager rideManager, Ride ride) {

	}

	@Override
	public void cancelRide(RideManager rideManager, Ride ride, User cancelledBy) {

	}

	@Override
	public PaymentRequest completeRide(RideManager rideManager, Ride ride) {
		return null;
	}
}
