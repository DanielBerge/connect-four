package player;

import board.IBoard;
import inf101.v18.extras.Token;

public interface IPlayer {
	/**
	 * 
	 * @return token of the player
	 */
	Token getToken();
	/**
	 * 
	 * @return true if AI, else false
	 */
	boolean isAi();
	/**
	 * 
	 * @param board
	 * @return x coordinate to place token
	 */

	int getMove(IBoard board);

}
