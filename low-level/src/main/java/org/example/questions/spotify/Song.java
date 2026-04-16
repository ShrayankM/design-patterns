package org.example.questions.spotify;

import lombok.Data;

import java.time.Duration;

@Data
public class Song {
	private String id;
	private String title;
	private Duration duration;
	private Genre genre;
	private Artist artist;
	private Album album;
	private Long likeCount;
	private Long dislikeCount;

	public Song(String title, Duration duration, Genre genre, Artist artist, Album album) {
		this.title = title;
		this.duration = duration;
		this.genre = genre;
		this.artist = artist;
		this.album = album;
		this.likeCount = 0L;
		this.dislikeCount = 0L;
	}

	public void incrementLikeCount() {
		this.likeCount++;
	}

	public void incrementDislikeCount() {
		this.dislikeCount++;
	}
}

