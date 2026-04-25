package org.example.questions.ticTacToe;

import lombok.Data;

@Data
public class Board {
	private Player [][] gameBoard;

	public Board(int rows, int columns) {
		this.gameBoard = new Player[rows][columns];
	}

	public void resetGameBoard() {
		int rows = gameBoard.length;
		int columns = gameBoard[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.gameBoard[i][j] = null;
			}
		}
	}

	public void makeMove(Move move) {
		int row = move.getRow();
		int column = move.getColumn();

		if (row < 0 || this.gameBoard.length < row) {
			System.out.println("Incorrect row-index");
			return;
		}

		if (column < 0 || this.gameBoard[0].length < column) {
			System.out.println("Incorrect column-index");
			return;
		}

		if (this.gameBoard[row][column] != null) {
			System.out.println("Illegal move, cannot place symbol here occupied");
			return;
		}

		this.gameBoard[row][column] = move.getPlayer();
	}

	public Player getSymbol(int row, int column) {
		return this.gameBoard[row][column];
	}
}
