package org.example.questions.spotify;

import java.util.List;

public class SongAlbumSearchStrategy implements SongSearchStrategy {
	private final SongSearchService songSearchService;

	public SongAlbumSearchStrategy(SongSearchService songSearchService) {
		this.songSearchService = songSearchService;
	}

	@Override
	public List<Song> searchSongs(SongSearchQuery query) {
		return this.songSearchService.searchByAlbum(query.getAlbum());
	}
}
