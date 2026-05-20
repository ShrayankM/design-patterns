package org.example.questions.rideSharing;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class UserManager {
	private Map<String, User> ridersMap;
	private Map<String, User> driverMap;
	private Map<String, User> userIdMap;

	public UserManager() {
		this.ridersMap = new HashMap<>();
		this.driverMap = new HashMap<>();
		this.userIdMap = new HashMap<>();
	}

	public void createUser(UserRequest userRequest) {
		if (Objects.isNull(userRequest)) {
			System.out.println("User object is null, cannot create new user");
		}

		User user = new User();
		user.setName(userRequest.getName());
		user.setUserType(userRequest.getUserType());
		user.setStatus(Status.ONLINE);

		this.userIdMap.put(user.getId(), user);

		if (UserType.RIDER.equals(userRequest.getUserType())) {
//			ridersMap.computeIfAbsent(user.getId(), k -> new HashMap<>()).put(user.getId(), user);
			ridersMap.put(user.getId(), user);
		}

		if (UserType.DRIVER.equals(userRequest.getUserType())) {
//			ridersMap.computeIfAbsent(UserType.DRIVER, k -> new HashMap<>()).put(user.getId(), user);
			driverMap.put(user.getId(), user);
		}
	}

	public List<User> returnAllOnlineDrivers() {
		return driverMap.values().stream()
				.filter(user -> Status.ONLINE.equals(user.getStatus()))
				.collect(Collectors.toList());
	}

	public void updateUserStatus(String userId, Status status) {
		User user = this.userIdMap.get(userId);
		UserType userType = user.getUserType();

		user.setStatus(status);
		this.userIdMap.put(userId, user);

		if (UserType.RIDER.equals(userType)) {
			//			ridersMap.computeIfAbsent(user.getId(), k -> new HashMap<>()).put(user.getId(), user);
			ridersMap.put(user.getId(), user);
		}

		if (UserType.DRIVER.equals(userType)) {
			//			ridersMap.computeIfAbsent(UserType.DRIVER, k -> new HashMap<>()).put(user.getId(), user);
			driverMap.put(user.getId(), user);
		}
	}
}
