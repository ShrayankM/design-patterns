package org.example.questions.spotify;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
	private String id;

	public User() {
		this.id = UUID.randomUUID().toString();
	}
}
