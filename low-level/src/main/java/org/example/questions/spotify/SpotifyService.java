package org.example.questions.spotify;

import lombok.Data;

import java.util.List;

@Data
public class SpotifyService {
	private SongLibrary songLibrary;
	private PlaybackService playbackService;
	private PlayistService playistService;
	private SongLikeDislikeService songLikeDislikeService;
	private SongSearchService songSearchService;
	private SongRecommendationService songRecommendationService;

	public SpotifyService() {
		this.songLibrary = new SongLibrary();
		this.playbackService = new PlaybackService();
		this.playistService = new PlayistService();
		this.songLikeDislikeService = new SongLikeDislikeService(this.songLibrary);
		this.songSearchService = new SongSearchService(this.songLibrary);
		this.songRecommendationService = new SongRecommendationService();
	}

	public void playSong(Song song, User user) {
		playbackService.playSong(song, user);
	}

	public void stopSong() {
		playbackService.stopSong();
	}

	public void createPlayList(String playListName, User user) {
		this.playistService.createPlayList(playListName, user);
	}

	public void addSongToPlayList(String playListName, User user, Song song) {
		this.playistService.addSongToPlaylist(user, playListName, song);
	}

	public void removeSongFromPlayList(String playListName, User user, Song song) {
		this.playistService.removeSongFromPlaylist(user, playListName, song);
	}

	public void likeSong(Song song, User user) {
		this.songLikeDislikeService.likeSong(song, user);
	}

	public void dislikeSong(Song song, User user) {
		this.songLikeDislikeService.dislikeSong(song, user);
	}

	public List<Song> recommendSongsUsingHistory(User user) {
		RecommendationStrategy recommendationStrategy = new SongHistoryRecommendationStrategy(this.playbackService);
		this.songRecommendationService.setRecommendationStrategy(recommendationStrategy);
		return this.songRecommendationService.recommendSongs(user);
	}

	public List<Song> recommendSongsByLikeAndDislike(User user) {
		RecommendationStrategy recommendationStrategy = new SongLikeDislikeRecommendationStrategy(this.songLikeDislikeService);
		this.songRecommendationService.setRecommendationStrategy(recommendationStrategy);
		return this.songRecommendationService.recommendSongs(user);
	}

	public List<Song> searchSong(SearchType type, SongSearchQuery query) {
		SongSearchStrategy strategy = switch (type) {
			case BY_NAME   -> new SongNameSearchStrategy(songSearchService);
			case BY_ARTIST -> new SongArtistSearchStrategy(songSearchService);
			case BY_ALBUM  -> new SongAlbumSearchStrategy(songSearchService);
		};
		return strategy.searchSongs(query);
	}
}
