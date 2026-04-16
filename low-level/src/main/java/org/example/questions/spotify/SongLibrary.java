package org.example.questions.spotify;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SongLibrary {
	private List<Song> songList;
	private Map<String, List<Song>> songNameMap;
	private Map<String, List<Song>> artistSongMap;
	private Map<String, List<Song>> albumSongMap;

	public SongLibrary() {
		this.songList = new ArrayList<>();
		this.songNameMap = new HashMap<>();
		this.artistSongMap = new HashMap<>();
		this.albumSongMap = new HashMap<>();
	}

	public void addSong(Song song) {
		this.songList.add(song);
		this.songNameMap.computeIfAbsent(song.getTitle(), s -> new ArrayList<>()).add(song);
		this.artistSongMap.computeIfAbsent(song.getArtist().getId(), s -> new ArrayList<>()).add(song);
		this.albumSongMap.computeIfAbsent(song.getAlbum().getId(), s -> new ArrayList<>()).add(song);
	}

	public void removeSong(Song song) {
		this.songList.remove(song);

		List<Song> songsForName = this.songNameMap.get(song.getTitle());
		songsForName.remove(song);
	}

	public void likeSong(Song song) {
		song.incrementLikeCount();
	}

	public void dislikeSong(Song song) {
		song.incrementDislikeCount();
	}
}
