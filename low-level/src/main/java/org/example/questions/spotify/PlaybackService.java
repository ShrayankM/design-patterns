package org.example.questions.spotify;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PlaybackService {
	private Song currentSong;
	private Map<String, List<Song>> songHistory;

	public PlaybackService() {
		this.songHistory = new HashMap<>();
		this.currentSong = null;
	}

	public void playSong(Song song, User user) {
		System.out.println("Playing song = " + song);
		this.currentSong = song;
		this.songHistory.computeIfAbsent(user.getId(), k -> new ArrayList<>()).add(song);
	}

	public void stopSong() {
		System.out.println("Stopping song = " + currentSong);
		currentSong = null;
	}
}
