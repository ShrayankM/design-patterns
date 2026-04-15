package org.example.questions.hotelBooking.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HotelSearchService {
	private final HotelBookingService hotelBookingService;

	public HotelSearchService(HotelBookingService hotelBookingService) {
		this.hotelBookingService = hotelBookingService;
	}

	public List<Hotel> searchHotels(String location, LocalDateTime startDate, LocalDateTime endDate, List<Hotel> hotelList) {
		List<Hotel> matchingHotels = new ArrayList<>();
		for (Hotel hotel : hotelList) {
			if (location.equals(hotel.getLocation())) {
				List<Room> availableRooms = hotelBookingService.searchRooms(hotel, startDate, endDate);

				if (!availableRooms.isEmpty()) {
					matchingHotels.add(hotel);
				}
			}
		}
		return matchingHotels;
	}
}
