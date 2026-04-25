package org.example.questions.ticTacToe;

import lombok.Data;

@Data
public class Player {
	private String symbol;

	public Player(String symbol) {
		this.symbol = symbol;
	}
}
