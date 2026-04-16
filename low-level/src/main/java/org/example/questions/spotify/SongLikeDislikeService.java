package org.example.questions.spotify;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
public class SongLikeDislikeService {
	private SongLibrary songLibrary;
	private Map<String, List<Song>> userLikedSongs;
	private Map<String, List<Song>> userDislikedSongs;

	public SongLikeDislikeService(SongLibrary songLibrary) {
		this.userLikedSongs = new HashMap<>();
		this.userDislikedSongs = new HashMap<>();
		this.songLibrary = songLibrary;
	}

	public void likeSong(Song song, User user) {
		this.songLibrary.likeSong(song);

		List<Song> dislikedSongs = userDislikedSongs.get(user.getId());
		if (Objects.nonNull(dislikedSongs) && !dislikedSongs.isEmpty()) {
			dislikedSongs.remove(song);
			userDislikedSongs.put(user.getId(), dislikedSongs);
		}
		userLikedSongs.computeIfAbsent(user.getId(), s -> new ArrayList<>()).add(song);
	}

	public void dislikeSong(Song song, User user) {
		this.songLibrary.dislikeSong(song);

		List<Song> likedSongs = userLikedSongs.get(user.getId());
		if (Objects.nonNull(likedSongs) && !likedSongs.isEmpty()) {
			likedSongs.remove(song);
			userLikedSongs.put(user.getId(), likedSongs);
		}

		userDislikedSongs.computeIfAbsent(user.getId(), s -> new ArrayList<>()).add(song);
	}
}
