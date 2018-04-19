package inf101.v18.fourinarow;

import java.util.Random;

public class AI extends AbstractPlayer {
	private Random r = new Random();
	
	public AI(Token t) {
		super(t);
	}
	
	@Override
	public int getMove(IBoard board) {
		return r.nextInt(board.getWidth());
	}
	
	@Override
	public boolean isAi() {
		return true;
	}
	
}
