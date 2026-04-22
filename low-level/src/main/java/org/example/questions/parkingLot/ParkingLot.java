package org.example.questions.parkingLot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingLot {
	 private Map<String, ParkingSpot> parkingSpotMap;
	 private Map<VehicleSize, Set<String>> vehicleSizeParkingSpotMap;

	 public ParkingLot() {
		 this.parkingSpotMap = new HashMap<>();
		 this.vehicleSizeParkingSpotMap = new HashMap<>();
	 }

	 public void addParkingSpot(VehicleSize vehicleSize, ParkingSpot parkingSpot) {
		 parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
		 Set<String> spots = vehicleSizeParkingSpotMap.getOrDefault(vehicleSize, new HashSet<>());
		 spots.add(parkingSpot.getId());
		 vehicleSizeParkingSpotMap.put(vehicleSize, spots);
	 }

	 public void removeParkingSpot(ParkingSpot parkingSpot) {

	 }

	 public ParkingSpot findParkingSpot(Vehicle vehicle) {
		 Set<String> parkingSpotIds = vehicleSizeParkingSpotMap.get(vehicle.getVehicleSize());

		 for (String parkingSpotId : parkingSpotIds) {
			 ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotId);
			 if (parkingSpot.isSpotVacant()) {
				 return parkingSpot;
			 }
		 }
		 return null;
	 }
}
