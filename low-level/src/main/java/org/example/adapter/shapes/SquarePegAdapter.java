package org.example.adapter.shapes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SquarePegAdapter extends RoundPeg {
	private final SquarePeg squarePeg;

	public SquarePegAdapter(SquarePeg squarePeg) {
		this.squarePeg = squarePeg;
	}

	@Override
	public BigDecimal getRadius(){
		// Calculate a minimum circle radius, which can fit this peg.
		return BigDecimal.valueOf(Math.sqrt(Math.pow((squarePeg.getWidth().divide(
				new BigDecimal("2.0"), RoundingMode.HALF_UP).longValue()), 2) * 2));
	}
}
