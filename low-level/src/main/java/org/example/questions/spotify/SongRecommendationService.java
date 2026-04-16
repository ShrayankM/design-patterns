package org.example.questions.spotify;

import lombok.Data;

import java.util.List;

@Data
public class SongRecommendationService {
	private RecommendationStrategy recommendationStrategy;

	public SongRecommendationService() {
	}

	public SongRecommendationService(RecommendationStrategy recommendationStrategy) {
		this.recommendationStrategy = recommendationStrategy;
	}

	public List<Song> recommendSongs(User user) {
		return this.recommendationStrategy.recommendSongs(user);
	}
}
