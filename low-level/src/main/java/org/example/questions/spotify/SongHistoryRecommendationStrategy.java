package org.example.questions.spotify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SongHistoryRecommendationStrategy implements RecommendationStrategy {
	private final PlaybackService playbackService;

	public SongHistoryRecommendationStrategy(PlaybackService playbackService) {
		this.playbackService = playbackService;
	}

	@Override
	public List<Song> recommendSongs(User user) {
		List<Song> userSongHistory = new ArrayList<>(this.playbackService.getSongHistory().get(user.getId()));
		Collections.reverse(userSongHistory);

		if (userSongHistory.size() < 5) {
			return userSongHistory;
		}
		return userSongHistory.subList(0, 5);
	}
}
