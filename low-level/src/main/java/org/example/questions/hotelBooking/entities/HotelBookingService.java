package org.example.questions.hotelBooking.entities;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
public class HotelBookingService {
	private final Map<String, Booking> bookingMap;
	private final PaymentService paymentService;
	private final PricingStrategy pricingStrategy;

	public HotelBookingService(PaymentService paymentService, PricingStrategy pricingStrategy) {
		this.bookingMap = new HashMap<>();
		this.paymentService = paymentService;
		this.pricingStrategy = pricingStrategy;
	}

	public List<Room> searchRooms(Hotel hotel, LocalDateTime startDate, LocalDateTime endDate) {
		List<Booking> bookingsForHotel = bookingMap.values().stream()
				.filter(filterBookings(hotel, startDate, endDate))
				.toList();

		// Collect all room IDs that are already booked during the requested period
		Set<String> bookedRoomIds = bookingsForHotel.stream()
				.flatMap(booking -> booking.getBookedRooms().stream())
				.map(Room::getId)
				.collect(Collectors.toSet());

		// Find rooms in this hotel that are NOT booked
		return hotel.getRoomMap().values().stream()
				.filter(room -> !bookedRoomIds.contains(room.getId()))
				.toList();
	}

	public Booking bookRoom(Hotel hotel, List<Room> rooms, LocalDateTime startDate, LocalDateTime endDate) {
		Booking booking = new Booking();

		booking.setBookedRooms(rooms);
		booking.setStartDate(startDate);
		booking.setEndDate(endDate);
		booking.setHotel(hotel);
		booking.setBookingStatus(BookingStatus.BOOKED);

		bookingMap.put(booking.getId(), booking);
		return booking;
	}

	public void cancelBooking(Booking booking) {
		booking.setBookingStatus(BookingStatus.CANCELLED);
		paymentService.initiateRefund(booking.getTotalPrice());
	}

	public void checkOut(Booking booking) {
		List<Room> rooms = booking.getBookedRooms();
		BigDecimal totalPrice = new BigDecimal("0.0");

		for (Room room : rooms) {
			totalPrice = totalPrice.add(pricingStrategy.calculatePrice(room, booking.getStartDate(), booking.getEndDate()));
		}
		paymentService.acceptPayment(totalPrice);
		booking.setTotalPrice(totalPrice);
		booking.setBookingStatus(BookingStatus.COMPLETED);
	}

	private static Predicate<Booking> filterBookings(Hotel hotel, LocalDateTime startDate, LocalDateTime endDate) {
		return booking -> booking.getHotel().getId().equals(hotel.getId())
				&& booking.getStartDate().isBefore(endDate) && booking.getEndDate().isAfter(startDate)
				&&
				(booking.getBookingStatus().equals(BookingStatus.BOOKED)
						|| booking.getBookingStatus().equals(BookingStatus.CHECKED_IN));
	}
}
