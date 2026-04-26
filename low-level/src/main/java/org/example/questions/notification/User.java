package org.example.questions.notification;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
	private String id;
	private String name;
	private String emailAddress;
	private String phoneNumber;

	public User(String name, String emailAddress, String phoneNumber) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}
}
