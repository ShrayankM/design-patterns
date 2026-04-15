package org.example.facadePattern;

import java.util.List;

public class HomeTheaterFacade {
	private MediaPlayer mediaPlayer;
	private SoundSystem soundSystem;
	private Projector projector;

	public void playMovie() {
		mediaPlayer.selectMedia("youtube");
		soundSystem.enableSound();
		soundSystem.setBass(10);
		soundSystem.setEqualizer(List.of(10, 2, 3, 56));
		projector.enableScreen();
		projector.startProjection();
		mediaPlayer.playMedia();
	}

	public void endMovie() {
		mediaPlayer.endMedia();
		projector.endProjection();
		projector.retractScreen();
		soundSystem.disableSound();
	}
}
