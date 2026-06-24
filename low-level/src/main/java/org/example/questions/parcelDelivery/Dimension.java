package org.example.questions.parcelDelivery;

import java.math.BigDecimal;

public class Dimension {
	private BigDecimal length;
	private BigDecimal width;
	private BigDecimal height;

	public Dimension(BigDecimal length, BigDecimal width, BigDecimal height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public BigDecimal calculateSize() {
		return length.multiply(width).multiply(height);
	}
}
