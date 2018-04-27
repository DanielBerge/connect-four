package game;

import java.util.Random;

import board.Board;
import board.IBoard;
import gui.GUI;
import player.IPlayer;

public class TurnHandler implements ITurnHandler {
	private int width = 7;
	private int height = 6;
	private IPlayer<Token> red;
	private IPlayer<Token> yellow;
	private IPlayer<Token> turn = null;
	private Random r = new Random();
	private boolean won = false;
	private IBoard<Token> board = new Board<>(width, height, Token.BLANK);
	/**
	 * Randomly choose turn
	 * If AI, do AI move.
	 * 
	 * @param p1 (AI or human 
	 * @param p2
	 */
	public TurnHandler(IPlayer<Token> p1, IPlayer<Token> p2) {
		red = p1;
		yellow = p2;
		if (r.nextInt(2) == 0) {
			turn = red;
		} else {
			turn = yellow;
			if (yellow.isAi()) {
				aiMove();
			}
			turn = red;
		}
	}

	@Override
	public void turn() {
		GUI.getGameScene().printScene();
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
			aiMove();
			if (checkWin())
				return;
			GUI.getGameScene().printScene();
			turn = red;
		}
		GUI.getGameScene().updateText(turn.getToken().getName() + "'s turn");
	}

	@Override
	public boolean checkWin() {
		Rule<Token> rule = new Rule<>();
		if (rule.hasWonFour(board, turn.getToken())) {
			GUI.getGameScene().updateText(turn.getToken().getName() + " WON!");
			GUI.getGameScene().printScene();
			won = true;
			return true;
		}
		return false;
	}

	@Override
	public void clicked(int x) {
		if (!won) {
			if (board.placeToken(x, turn.getToken())) {
				GUI.getGameScene().printScene();
				turn();
			} else {
				GUI.getGameScene().printScene();
				GUI.getGameScene().updateText("Column full, still " + turn.getToken().getName().toLowerCase() + "'s turn");
			}
		} else {
			GUI.getGameScene().printScene();
		}
	}
	
	@Override
	public void aiMove() {
		int i = yellow.getMove(board);
		while (!board.placeToken(i, turn.getToken())) {
			i = yellow.getMove(board);
		}
	}

	@Override
	public IPlayer<Token> getTurn() {
		return turn;
	}

	@Override
	public IBoard<Token> getBoard() {
		return board;
	}
}
