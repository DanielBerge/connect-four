package game;

import board.IBoard;

public class Rule<T> {
	/**
	 * Iterate trough every element in grid, 
	 * and check directions if game is won
	 * 
	 * @param board
	 * @param t (player)
	 * @return if game is won or not by "t"
	 */
	public boolean hasWonFour(IBoard<T> board, T t) {
		for(int x = 0; x < board.getWidth(); x++) {
			for(int y = 0; y < board.getHeight(); y++) {
				//Vertical
				if((board.get(x, y) == t) 
					&& (board.get(x, y+1) == t) 
					&& (board.get(x, y+2) == t)
					&& (board.get(x, y+3) == t)) {
					return true;
				//Horizontal
				} else if((board.get(x, y) == t)
					&& (board.get(x+1, y) == t) 
					&& (board.get(x+2, y) == t) 
					&& (board.get(x+3, y) == t)) {
					return true;
				//Diagonal
				} else if((board.get(x, y) == t)
					&& (board.get(x+1, y+1) == t) 
					&& (board.get(x+2, y+2) == t) 
					&& (board.get(x+3, y+3) == t)) {
					return true;
				//Diagonal
				} else if((board.get(x, y) == t)
					&& (board.get(x-1, y+1) == t) 
					&& (board.get(x-2, y+2) == t) 
					&& (board.get(x-3, y+3) == t)) {
					return true;
				}
			}
		}
		return false;
	}
}
