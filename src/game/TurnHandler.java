package game;

import java.util.Random;

import board.Board;
import board.IBoard;
import gui.GUI;
import player.IPlayer;

public class TurnHandler {
	private int width = 7;
	private int height = 6;
	private IPlayer<Token> red;
	private IPlayer<Token> yellow;
	private IPlayer<Token> turn = null;
	private Random r = new Random();
	private boolean won = false;
	private IBoard<Token> board = new Board<>(width, height, Token.BLANK);

	public TurnHandler(IPlayer<Token> p1, IPlayer<Token> p2) {
		red = p1;
		yellow = p2;
		if (r.nextInt(2) == 0) {
			turn = red;
		} else {
			turn = yellow;
			if (yellow.isAi()) {
				int i = yellow.getMove(board);
				while (!board.placeToken(i, turn.getToken())) {
					i = yellow.getMove(board);
				}
				turn = red;
			}
		}
	}

	public void turn() {
		if (checkWin())
			return;
		if (board.isFull()) {
			GUI.getGameScene().updateText("Board full, it's a tie");
			won = true;
			return;
		}

		if (turn == yellow) {
			turn = red;
		} else if (turn == red) {
			turn = yellow;
		}

		if (yellow.isAi()) {
			int i = yellow.getMove(board);
			while (!board.placeToken(i, turn.getToken())) {
				i = yellow.getMove(board);
			}
			if (checkWin())
				return;
			turn = red;
		}

		GUI.getGameScene().updateText(turn.getToken().getName() + "'s turn");
	}

	private boolean checkWin() {
		if (Rules.hasWonFour(board, turn.getToken())) {
			GUI.getGameScene().updateText(turn.getToken().getName() + " WON!");
			GUI.getGameScene().printScene();
			won = true;
			return true;
		}
		return false;
	}

	public void clicked(int i) {
		if (!won) {
			if (board.placeToken(i, turn.getToken())) {
				GUI.getGameScene().printScene();
				turn();
			} else {
				GUI.getGameScene().printScene();
				GUI.getGameScene()
						.updateText("Column full, still " + turn.getToken().getName().toLowerCase() + "'s turn");
			}
		} else {
			GUI.getGameScene().printScene();
		}
	}

	public IPlayer<Token> getTurn() {
		return turn;
	}

	public IBoard<Token> getBoard() {
		return board;
	}
}
