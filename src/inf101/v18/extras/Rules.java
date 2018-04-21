package inf101.v18.extras;

import board.IBoard;

public class Rules {
	public static boolean hasWonFour(IBoard<Token> board, Token t) {
		for(int x = 0; x < board.getWidth(); x++) {
			for(int y = 0; y < board.getHeight(); y++) {
				if((board.get(x, y) == t)
					&& (board.get(x, y+1) == t) 
					&& (board.get(x, y+2) == t)
					&& (board.get(x, y+3) == t)) {
					return true;
				} else if((board.get(x, y) == t)
					&& (board.get(x+1, y) == t) 
					&& (board.get(x+2, y) == t) 
					&& (board.get(x+3, y) == t)) {
					return true;
				} else if((board.get(x, y) == t)
					&& (board.get(x+1, y+1) == t) 
					&& (board.get(x+2, y+2) == t) 
					&& (board.get(x+3, y+3) == t)) {
					return true;
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
