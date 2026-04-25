package org.example.questions.ticTacToe;

import lombok.Data;

@Data
public class GameState {
	private boolean isGameCompleted;
	private Player winner;

	public GameState(boolean isGameCompleted, Player winner) {
		this.isGameCompleted = isGameCompleted;
		this.winner = winner;
	}
}
