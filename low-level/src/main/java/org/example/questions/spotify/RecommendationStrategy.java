package org.example.questions.spotify;

import java.util.List;

public interface RecommendationStrategy {
	List<Song> recommendSongs(User user);
}
