package org.example.questions.ticTacToe;

import lombok.Data;

@Data
public class Move {
	private Player player;
	private int row;
	private int column;

	public Move(Player player, int row, int column) {
		this.player = player;
		this.row = row;
		this.column = column;
	}
}
