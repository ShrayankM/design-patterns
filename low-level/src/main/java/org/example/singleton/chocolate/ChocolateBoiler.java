package org.example.singleton.chocolate;

import java.util.Objects;

public class ChocolateBoiler {
	private static volatile ChocolateBoiler instance;
	private Boolean empty;
	private Boolean boiled;

	private ChocolateBoiler() {
		this.empty = true;
		this.boiled = false;
	}

	public static ChocolateBoiler getInstance() {
		if (Objects.isNull(instance)) {
			synchronized (ChocolateBoiler.class) {
				if(Objects.isNull(instance)) {
					instance = new ChocolateBoiler();
				}
			}
		}
		return instance;
	}

	public void fill() {
		if (isEmpty()) {
			// fill it up
			this.empty = false;
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			// boil it up
			this.boiled = true;
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			// start draining boild milk & chocolate
			this.empty = true;
			this.boiled = false;
		}
	}

	public Boolean isEmpty() {
		return this.empty;
	}

	public Boolean isBoiled() {
		return this.boiled;
	}
}
