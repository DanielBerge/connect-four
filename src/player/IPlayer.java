package player;

import board.IBoard;

public interface IPlayer<T> {
	/**
	 * 
	 * @return token of the player
	 */
	T getToken();
	/**
	 * 
	 * @return true if AI, else false
	 */
	boolean isAi();
	/**
	 * Gets a random move
	 * 
	 * @param board
	 * @param element if ai
	 * @param enemy element
	 * @return x coordinate to place token
	 */
	int getMove(IBoard<T> board, T elem);

}
