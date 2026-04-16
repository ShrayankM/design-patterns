package org.example.questions.spotify;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class SongLikeDislikeRecommendationStrategy implements RecommendationStrategy {
	private SongLikeDislikeService songLikeDislikeService;

	public SongLikeDislikeRecommendationStrategy(SongLikeDislikeService songLikeDislikeService) {
		this.songLikeDislikeService = songLikeDislikeService;
	}

	@Override
	public List<Song> recommendSongs(User user) {
		List<Song> likedSongs = new ArrayList<>(songLikeDislikeService.getUserLikedSongs().get(user.getId()));
		Collections.reverse(likedSongs);

		if (likedSongs.size() < 5) {
			return likedSongs;
		}
		return likedSongs.subList(0, 5);
	}
}
