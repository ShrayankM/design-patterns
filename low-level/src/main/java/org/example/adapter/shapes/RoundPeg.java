package org.example.adapter.shapes;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class RoundPeg {
	private BigDecimal radius;

	public RoundPeg() {}

	public RoundPeg(BigDecimal radius) {
		this.radius = radius;
	}
}
