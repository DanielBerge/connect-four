package inf101.v18.fourinarow;

public class Rules {
	public static boolean hasWonFour(IBoard board, Token t) {
		for(int x = 0; x < board.getWidth(); x++) {
			for(int y = 0; y < board.getHeight(); y++) {
				if((board.getToken(x, y) == t)
					&& (board.getToken(x, y+1) == t) 
					&& (board.getToken(x, y+2) == t)
					&& (board.getToken(x, y+3) == t)) {
					return true;
				} else if((board.getToken(x, y) == t)
					&& (board.getToken(x+1, y) == t) 
					&& (board.getToken(x+2, y) == t) 
					&& (board.getToken(x+3, y) == t)) {
					return true;
				} else if((board.getToken(x, y) == t)
					&& (board.getToken(x+1, y+1) == t) 
					&& (board.getToken(x+2, y+2) == t) 
					&& (board.getToken(x+3, y+3) == t)) {
					return true;
				} else if((board.getToken(x, y) == t)
					&& (board.getToken(x-1, y+1) == t) 
					&& (board.getToken(x-2, y+2) == t) 
					&& (board.getToken(x-3, y+3) == t)) {
					return true;
				}
			}
		}
		return false;
	}
}
