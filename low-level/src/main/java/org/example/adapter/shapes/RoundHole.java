package org.example.adapter.shapes;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class RoundHole {
	private final BigDecimal radius;

	public RoundHole(BigDecimal radius) {
		this.radius = radius;
	}

	public boolean fits(RoundPeg roundPeg) {
		return this.radius.compareTo(roundPeg.getRadius()) >= 0;
	}
}
