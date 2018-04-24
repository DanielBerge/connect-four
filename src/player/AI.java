package player;

import java.util.Random;
import board.IBoard;
import game.Rules;
import game.Token;

public class AI<T extends Token> extends AbstractPlayer<T> {
	private Random r = new Random();
	
	public AI(T t) {
		super(t);
	}
	
	@Override
	public int getMove(IBoard<T> board) {
		IBoard<T> tboard = board.copy();
		if(tboard.isFull()) {
			return 0;
		}
		
		for(int x = 0; x <tboard.getWidth(); x++) {
			if(canPlay(x, tboard) && isWinningMove(tboard, x)) {
				return x;
			}
		}
		

		return r.nextInt(tboard.getWidth());
	}
	
	@Override
	public boolean isAi() {
		return true;
	}
	
	private boolean isWinningMove(IBoard<T> board, int x) {
		IBoard<T> tboard = board.copy();
		Rules<T> rule = new Rules<>();
		tboard.placeToken(x, t);
		if(rule.hasWonFour(tboard, t)) {
			return true;
		}
		return false;
	}
	
	private boolean canPlay(int x, IBoard<T> board) {
		IBoard<T> tboard = board.copy();
		return tboard.placeToken(x, t);
	}
	
}
