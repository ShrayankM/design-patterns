package org.example.singleton;

import java.util.Objects;

public class Singleton {
	// create static instance variable for class
	public static Singleton instance;

	// make the constructor private
	private Singleton() {}

	// check if instance is null & return instance
	public static Singleton getInstance() {
		if (Objects.isNull(instance)) {
			instance = new Singleton();
		}
		return instance;
	}
}
