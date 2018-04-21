package player;

import java.util.Random;
import board.IBoard;

public class AI<T> extends AbstractPlayer<T> {
	private Random r = new Random();
	
	public AI(T t) {
		super(t);
	}
	
	@Override
	public int getMove(IBoard<T> board) {
		return r.nextInt(board.getWidth());
	}
	
	@Override
	public boolean isAi() {
		return true;
	}
	
}
