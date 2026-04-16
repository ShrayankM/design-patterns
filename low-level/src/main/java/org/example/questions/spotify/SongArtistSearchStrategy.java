package org.example.questions.spotify;

import java.util.List;

public class SongArtistSearchStrategy implements SongSearchStrategy {
	private final SongSearchService songSearchService;

	public SongArtistSearchStrategy(SongSearchService songSearchService) {
		this.songSearchService = songSearchService;
	}

	@Override
	public List<Song> searchSongs(SongSearchQuery query) {
		return this.songSearchService.searchSongByArtist(query.getArtist());
	}
}
