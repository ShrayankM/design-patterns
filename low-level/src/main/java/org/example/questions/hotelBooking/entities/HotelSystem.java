package org.example.questions.hotelBooking.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HotelSystem {
	private final HotelBookingService hotelBookingService;
	private final HotelSearchService hotelSearchService;
	private final List<Hotel> hotelList;

	public HotelSystem(HotelBookingService hotelBookingService,
			HotelSearchService hotelSearchService) {
		this.hotelBookingService = hotelBookingService;
		this.hotelSearchService = hotelSearchService;
		this.hotelList = new ArrayList<>();
	}

	public void addHotel(Hotel hotel) {
		hotelList.add(hotel);
	}

	public void addRooms(Hotel hotel, List<Room> rooms) {
		hotel.addRooms(rooms);
	}

	public Booking bookRooms(Hotel hotel, List<Room> rooms, LocalDateTime startDate, LocalDateTime endDate) {
		return hotelBookingService.bookRoom(hotel, rooms, startDate, endDate);
	}

	public void cancelBooking(Booking booking) {
		hotelBookingService.cancelBooking(booking);
	}

	public void checkOut(Hotel hotel, Booking booking) {
		hotelBookingService.checkOut(booking);
	}

	public List<Hotel> searchHotels(String location, LocalDateTime startDate, LocalDateTime endDate) {
		return hotelSearchService.searchHotels(location, startDate, endDate, this.hotelList);
	}
}
