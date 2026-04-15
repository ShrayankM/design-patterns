package org.example.questions.hotelBooking.entities;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class Hotel {
	private String id;
	private String location;
	private Map<String, Room> roomMap;

	public void addRooms(List<Room> roomList) {
		for (Room room : roomList) {
			roomMap.put(room.getId(), room);
		}
	}
}
