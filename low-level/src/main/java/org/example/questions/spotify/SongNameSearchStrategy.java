package org.example.questions.spotify;

import java.util.List;

public class SongNameSearchStrategy implements SongSearchStrategy {
	private final SongSearchService songSearchService;

	public SongNameSearchStrategy(SongSearchService songSearchService) {
		this.songSearchService = songSearchService;
	}

	@Override
	public List<Song> searchSongs(SongSearchQuery query) {
		return this.songSearchService.searchSongByName(query.getSongName());
	}
}
