package org.example.questions.spotify;

import lombok.Data;

@Data
public class SongSearchQuery {
	private String songName;
	private Artist artist;
	private Album album;

	public static SongSearchQuery byName(String name) {
		SongSearchQuery q = new SongSearchQuery();
		q.songName = name;
		return q;
	}

	public static SongSearchQuery byArtist(Artist artist) {
		SongSearchQuery q = new SongSearchQuery();
		q.artist = artist;
		return q;
	}

	public static SongSearchQuery byAlbum(Album album) {
		SongSearchQuery q = new SongSearchQuery();
		q.album = album;
		return q;
	}
}
