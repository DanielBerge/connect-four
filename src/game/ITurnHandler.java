package game;

import board.IBoard;
import player.IPlayer;

public interface ITurnHandler {
	/**
	 * Check if someone won, and if board is full
	 * Change turn
	 * If AI, execute AI move
	 */
	void turn();
	/**
	 * Places token at given x coordinate
	 * If fails, print message
	 * 
	 * @param x 
	 */
	void clicked(int x);
	/**
	 * If player won, print win-message and end game
	 * 
	 * @return if current player won
	 */
	boolean checkWin();
	/**
	 * 
	 * @return player that currently has turn
	 */
	IPlayer<Token> getTurn();
	/**
	 * @return current board of game
	 */
	IBoard<Token> getBoard();
	/**
	 * Tries to place token until it can
	 */
	void aiMove();

}
