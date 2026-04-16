package org.example.questions.spotify;

import java.util.List;

public interface SongSearchStrategy {
		List<Song> searchSongs(SongSearchQuery query);
}
