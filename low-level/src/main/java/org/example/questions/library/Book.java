package org.example.questions.library;

import lombok.Data;

@Data
public class Book {
	private String id;
	private String name;
	private Author author;
	private Genre genre;

	public Book(String id, String name, Author author, Genre genre) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.genre = genre;
	}
}
