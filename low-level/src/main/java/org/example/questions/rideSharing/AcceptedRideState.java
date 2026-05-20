package org.example.questions.rideSharing;

import java.util.Objects;

public class AcceptedRideState implements RideState {
	@Override
	public Ride requestRide(RideManager riderManager, RideRequest rideRequest) {
		return null;
	}

	@Override
	public void acceptRide(RideManager rideManager, User driver, String rideId) {
//		Ride currentRideData = this.rideMap.get(rideId);
		Ride currentRideData = rideManager.getCurrentRideData(rideId);

		if (Objects.isNull(currentRideData)) {
			System.out.println("Ride with id = " + rideId + " does not exist");
			return;
		}

		if (RideStatus.REQUESTED.equals(currentRideData.getRideStatus())) {
			currentRideData.setRideStatus(RideStatus.DRIVER_ASSIGNED);
			currentRideData.setDriver(driver);
			rideManager.notifyRider(currentRideData.getRider(), currentRideData);
//			this.rideMap.put(rideId, currentRideData);
			rideManager.updateRideMap(rideId, currentRideData);
			rideManager.updateRideState(rideId, new RideStartedState());
		} else {
			System.out.println("Ride is already in-progress or cancelled");
		}
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
