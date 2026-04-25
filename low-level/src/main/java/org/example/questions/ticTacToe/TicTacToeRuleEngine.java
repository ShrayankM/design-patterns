package org.example.questions.ticTacToe;

import java.util.Objects;

public class TicTacToeRuleEngine implements GameRuleEngine {
	@Override
	public GameState getGameState(Board board) {
		GameState rowState = checkRows(board);
		if (rowState.isGameCompleted()) return rowState;

		GameState columnState = checkColumns(board);
		if (columnState.isGameCompleted()) return columnState;

		GameState diagonalState = checkDiagonal(board);
		if (diagonalState.isGameCompleted()) return diagonalState;

		GameState reverseDiagonalState = checkReverseDiagonal(board);
		if (reverseDiagonalState.isGameCompleted()) return reverseDiagonalState;

		return new GameState(false, null);
	}

	private GameState checkRows(Board board) {
		int rows = board.getGameBoard().length;
		int columns = board.getGameBoard()[0].length;
		for (int i = 0; i < rows; i++) {
			Player p = board.getSymbol(i, 0);
			if (p == null) continue;

			int equalCount = 1;
			for (int j = 1; j < columns; j++) {
				Player q = board.getSymbol(i, j);
				if (Objects.nonNull(q) && p.getSymbol().equals(q.getSymbol())) {
					equalCount++;
				}
			}

			if (equalCount == columns) {
				return new GameState(true, p);
			}
		}
		return new GameState(false, null);
	}

	private GameState checkColumns(Board board) {
		int rows = board.getGameBoard().length;
		int columns = board.getGameBoard()[0].length;
		for (int i = 0; i < columns; i++) {
			Player p = board.getSymbol(0, i);
			if (p == null) continue;

			int equalCount = 1;
			for (int j = 1; j < rows; j++) {
				Player q = board.getSymbol(j, i);
				if (Objects.nonNull(q) && p.getSymbol().equals(q.getSymbol())) {
					equalCount++;
				}
			}

			if (equalCount == rows) {
				return new GameState(true, p);
			}
		}
		return new GameState(false, null);
	}

	private GameState checkDiagonal(Board board) {
		int n = board.getGameBoard().length;
		Player p = board.getSymbol(0, 0);

		if (Objects.isNull(p)) return new GameState(false, null);

		int equalCount = 1;
		for (int i = 1; i < n; i++) {
			Player q = board.getSymbol(i, i);
			if (Objects.nonNull(q) && p.getSymbol().equals(q.getSymbol())) {
				equalCount++;
			}
		}

		if (equalCount == n) {
			return new GameState(true, p);
		}
		return new GameState(false, null);
	}

	private GameState checkReverseDiagonal(Board board) {
		int n = board.getGameBoard().length;
		Player p = board.getSymbol(0, n - 1);

		if (Objects.isNull(p)) return new GameState(false, null);

		int equalCount = 1;
		for (int i = 1; i < n; i++) {
			Player q = board.getSymbol(i, n - i - 1);
			if (Objects.nonNull(q) && p.getSymbol().equals(q.getSymbol())) {
				equalCount++;
			}
		}

		if (equalCount == n) {
			return new GameState(true, p);
		}
		return new GameState(false, null);
	}

	private GameState checkDraw(Board board) {
		int rows = board.getGameBoard().length;
		int columns = board.getGameBoard()[0].length;

		int boardCount = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Player p = board.getSymbol(i, j);
				if (Objects.nonNull(p)) boardCount++;
			}
		}

		if (boardCount == (rows * columns)) return new GameState(true, null);
		return new GameState(false, null);
	}
}
