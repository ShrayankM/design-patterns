package org.example.questions.spotify;

import lombok.Data;

import java.util.UUID;

@Data
public class Album {
	private String id;
	private String name;

	public Album(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}
}
