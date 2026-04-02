package org.example.adapter.shapes;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class SquarePeg {
	private BigDecimal width;

	public SquarePeg(BigDecimal width) {
		this.width = width;
	}

//	public double getSquare() {
//		double result;
//		result = Math.pow(this.width, 2);
//		return result;
//	}
}
