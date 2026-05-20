package org.example.questions.rideSharing;

public class RideCompletedState implements RideState {
	@Override
	public Ride requestRide(RideManager riderManager, RideRequest rideRequest) {
		return null;
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
