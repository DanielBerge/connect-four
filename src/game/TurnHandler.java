package game;

import java.util.Random;

import board.Board;
import board.IBoard;
import gui.GUI;
import player.AI;
import player.Human;
import player.IPlayer;

public class TurnHandler {
	private int width = 7;
	private int height = 6;
	private IPlayer<Token> red;
	private IPlayer<Token> yellow;
	private Token turn = null;
	private Random r = new Random();
	private boolean won = false;
	private IBoard<Token> board = new Board<>(width, height, Token.BLANK);
	
	public TurnHandler(AI<Token> ai) {
		if (ai == null) {
			red = new Human<>(Token.RED);
			yellow = new Human<>(Token.YELLOW);
		} else {
			red = new Human<>(Token.RED);
			yellow = ai;
		}

		if (r.nextInt(2) == 0) {
			turn = red.getToken();
		} else {
			turn = yellow.getToken();
			if(yellow.isAi()) {
				turn = red.getToken();
			}
		}
	}
	
	public void turn() {
		if (Rules.hasWonFour(board, turn)) {
			GUI.getGameScene().updateText(turn.getName() + " WON!");
			won = true;
			return;
		}
		if(board.isFull()) {
			GUI.getGameScene().updateText("Board full, it's a tie");
			won = true;
			return;
		}
		
		if (turn == red.getToken()) {
			turn = yellow.getToken();
			if (yellow.isAi()) {
				int i = yellow.getMove(board);
				while (!board.placeToken(i, turn)) {
					i = yellow.getMove(board);
				}
				turn();
			}
		} else {
			turn = red.getToken();
		}
		GUI.getGameScene().updateText(turn.getName() + "'s turn");
	}

	public void clicked(int i) {
		if (!won) {
			if (board.placeToken(i, turn)) {
				GUI.getGameScene().printScene();
				turn();
			} else {
				GUI.getGameScene().printScene();
				GUI.getGameScene().updateText("Column full, still " + turn.getName().toLowerCase() + "'s turn");
			}
		} else {
			GUI.getGameScene().printScene();
		}
	}
	
	public Token getTurn() {
		return turn;
	}
	
	public IBoard<Token> getBoard() {
		return board;
	}
}
