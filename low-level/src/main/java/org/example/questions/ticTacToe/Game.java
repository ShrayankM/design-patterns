package org.example.questions.ticTacToe;


import java.util.List;
import java.util.Objects;

public class Game {
	private List<Player> players;
	private Board board;
	private Player playerTurn;
	private int currentPlayerIndex;
	private GameRuleEngine gameRuleEngine;
	private GameState gameState;

	public Game(List<Player> players, int boardRows, int boardColumns, GameRuleEngine gameRuleEngine) {
		this.players = players;
		this.board = new Board(boardRows, boardColumns);
		this.currentPlayerIndex = 0;
		this.playerTurn = players.get(currentPlayerIndex);
		this.gameRuleEngine = gameRuleEngine;
		this.gameState = new GameState(false, null);
	}

	public void playMove(Move move) {
		Player player = move.getPlayer();
		if (Objects.nonNull(player)) {
			if (this.gameState.isGameCompleted()) {
				// game is over
				if(Objects.nonNull(gameState.getWinner())) {
					System.out.println("Game winner is " + gameState.getWinner().getSymbol());
				} else {
					System.out.println("Game is a draw");
				}
				return;
			}

			if (this.playerTurn.getSymbol().equals(player.getSymbol())) {
				this.board.makeMove(move);

				// check the game status
				this.gameState = gameRuleEngine.getGameState(this.getGameBoard());
				if (this.gameState.isGameCompleted()) {
					// game is over
					if(Objects.nonNull(this.gameState.getWinner())) {
						System.out.println("Game winner is " + this.gameState.getWinner().getSymbol());
					} else {
						System.out.println("Game is a draw");
					}
					return;
				}

				System.out.println("Player = " + player.getSymbol() + " move at ("
						 + move.getRow() + ", " + move.getColumn() + ")" );
				currentPlayerIndex = (currentPlayerIndex + 1) % this.players.size();
				this.playerTurn = this.players.get(currentPlayerIndex);
			} else {
				System.out.println("Please wait for your turn, player = " + this.playerTurn.getSymbol()
						+ " make your move");
			}
		}
	}

	public void restartGame() {
		this.board.resetGameBoard();
		this.gameState = new GameState(false, null);
		this.currentPlayerIndex = 0;
		this.playerTurn = players.get(currentPlayerIndex);
	}

	public Board getGameBoard() {
		return this.getGameBoard();
	}
}
