package org.example.facadePattern;

import java.util.List;

public interface SoundSystem {
	void enableSound();
	void setBass(int value);
	void setEqualizer(List<Integer> values);
	void disableSound();
}
