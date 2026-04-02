package org.example.adapter.shapes;

import java.math.BigDecimal;

public class ShapesDemo {
	public static void main(String [] args) {

		RoundHole a = new RoundHole(new BigDecimal("10.0"));
		SquarePeg sa = new SquarePeg(new BigDecimal("3.3"));

		SquarePegAdapter squarePegAdapter = new SquarePegAdapter(sa);

		if(a.fits(squarePegAdapter)) {
			System.out.println("Square peg fits in round-hole");
		};
	}
}
