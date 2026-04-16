package org.example.questions.spotify;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class SongSearchService {
	private SongLibrary songLibrary;

	public SongSearchService(SongLibrary songLibrary) {
		this.songLibrary = songLibrary;
	}

	public List<Song> searchSongByName(String name) {
		List<Song> songs = songLibrary.getSongNameMap().get(name);
		if (Objects.nonNull(songs) && !songs.isEmpty()) {
			return songs;
		}
		return new ArrayList<>();
	}

	public List<Song> searchSongByArtist(Artist artist) {
		List<Song> songs = songLibrary.getArtistSongMap().get(artist.getId());
		if (Objects.nonNull(songs) && !songs.isEmpty()) {
			return songs;
		}
		return new ArrayList<>();
	}

	public List<Song> searchByAlbum(Album album) {
		List<Song> songs = songLibrary.getAlbumSongMap().get(album.getId());
		if (Objects.nonNull(songs) && !songs.isEmpty()) {
			return songs;
		}
		return new ArrayList<>();
	}
}
