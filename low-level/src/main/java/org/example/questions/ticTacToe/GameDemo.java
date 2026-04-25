package org.example.questions.ticTacToe;

import java.util.List;

public class GameDemo {
	public static void main(String [] args) {
		Player O = new Player("O");
		Player X = new Player("X");

		Game game = new Game(List.of(O, X), 3, 3, new TicTacToeRuleEngine());

		game.playMove(new Move(O, 0, 0));
		game.playMove(new Move(X, 1, 1));
		game.playMove(new Move(O, 0, 2));
		game.playMove(new Move(X, 2, 2));
		game.playMove(new Move(O, 0, 1));
		game.playMove(new Move(X, 1, 2));

		game.restartGame();

		game.playMove(new Move(O, 0, 0));
		game.playMove(new Move(X, 1, 1));
		game.playMove(new Move(O, 0, 2));
		game.playMove(new Move(X, 2, 2));
		game.playMove(new Move(O, 0, 1));
	}
}
