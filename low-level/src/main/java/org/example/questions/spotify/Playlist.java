package org.example.questions.spotify;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Playlist {
	private String id;
	private String name;
	private User user;
	private List<Song> songList;

	public Playlist(String name, User user) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.user = user;
		this.songList = new ArrayList<>();
	}

	public void addSong(Song song) {
		this.songList.add(song);
	}

	public void removeSong(Song song) {
		this.songList.remove(song);
	}
}
