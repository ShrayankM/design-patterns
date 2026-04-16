package org.example.questions.spotify;

import lombok.Data;

import java.util.List;

@Data
public class SongRecommendationService {
	public List<Song> recommendSongs(User user, RecommendationStrategy recommendationStrategy) {
		return recommendationStrategy.recommendSongs(user);
	}
}
