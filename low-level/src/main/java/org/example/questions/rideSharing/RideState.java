package org.example.questions.rideSharing;

public interface RideState {
	Ride requestRide(RideManager riderManager, RideRequest rideRequest);
	void acceptRide(RideManager rideManager, User driver, String rideId);
	void startRide(RideManager rideManager, Ride ride);
	void cancelRide(RideManager rideManager, Ride ride, User cancelledBy);
	PaymentRequest completeRide(RideManager rideManager, Ride ride);
}
