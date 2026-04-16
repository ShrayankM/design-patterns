package org.example.questions.spotify;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PlayistService {
	private Map<String, List<Playlist>> userPlayistMap;

	public PlayistService() {
		this.userPlayistMap = new HashMap<>();
	}

	public void createPlayList(String playlistName, User user) {
		Playlist playlist = new Playlist(playlistName, user);
		userPlayistMap.computeIfAbsent(user.getId(), s -> new ArrayList<>()).add(playlist);
	}

	public void addSongToPlaylist(User user, String playlistName, Song song) {
		List<Playlist> userPlaylist = userPlayistMap.get(user.getId());

		for (Playlist playlist : userPlaylist) {
			if (playlist.getName().equals(playlistName)) {
				playlist.addSong(song);
				return;
			}
		}
		createPlayList(playlistName, user);
	}

	public void removeSongFromPlaylist(User user, String playlistName, Song song) {
		List<Playlist> userPlaylist = userPlayistMap.get(user.getId());

		for (Playlist playlist : userPlaylist) {
			if (playlist.getName().equals(playlistName)) {
				playlist.removeSong(song);
				return;
			}
		}
	}
}
