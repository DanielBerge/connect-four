package inf101.v18.fourinarow;

import java.util.Random;

public class AI {
	Random r = new Random();
	private Token t;
	
	public AI(Token t) {
		this.t = t;
	}
	public int getMove(IBoard board) {
		return r.nextInt(board.getWidth());
	}
	
	public Token getToken() {
		return t;
	}
}
