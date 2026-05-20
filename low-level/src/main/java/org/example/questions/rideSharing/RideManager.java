package org.example.questions.rideSharing;

import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
public class RideManager {
	private UserManager userManager;
	private LocationService locationService;
	private FareCalculator fareCalculator;
	private NotificationService notificationService;
	private Map<String, Ride> rideMap;
//	private RideState rideState;
	private Map<String, RideState> rideStateMap;

	public RideManager(UserManager userManager, LocationService locationService, FareCalculator fareCalculator,
			NotificationService notificationService) {
		this.userManager = userManager;
		this.locationService = locationService;
		this.fareCalculator = fareCalculator;
		this.notificationService = notificationService;
		this.rideMap = new HashMap<>();
		this.rideStateMap = new HashMap<>();
	}

	public Ride requestRide(RideRequest rideRequest) {
		RideState newRideState = new RequestRideState(this.locationService,
				this.fareCalculator);


		Ride ride = newRideState.requestRide(this, rideRequest);
		this.rideStateMap.put(ride.getId(), newRideState);
		return ride;
	}

	public void acceptRide(User driver, String rideId) {
		RideState rideState = this.rideStateMap.get(rideId);
		rideState.acceptRide(this, driver, rideId);
	}

	protected void updateRideState(String rideId, RideState rideState) {
		this.rideStateMap.put(rideId, rideState);
	}

	protected void updateRideMap(String rideId, Ride ride) {
		this.rideMap.put(rideId, ride);
	}

	protected Ride getCurrentRideData(String rideId) {
		return this.rideMap.get(rideId);
	}

	protected void notifyNearByRiders(Ride ride) {
		List<User> drivers = userManager.returnAllOnlineDrivers();
		List<User> nearbyDrivers = locationService.findNearByDrivers(drivers, ride);

		Event event = new Event();
		event.setRideData(ride);

		for (User driver : nearbyDrivers) {
			notificationService.notifyUser(event, driver);
		}
	}

	protected void notifyRider(User rider, Ride ride) {
		Event event = new Event();
		event.setRideData(ride);
		notificationService.notifyUser(event, rider);
	}
}
