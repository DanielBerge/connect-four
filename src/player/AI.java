package player;

import java.util.Random;
import board.IBoard;
import game.Rule;
import game.Token;

public class AI<T> extends AbstractPlayer<T> {
	private Random r = new Random();
	
	public AI(T t) {
		super(t);
	}
	
	@Override
	public boolean isAi() {
		return true;
	}
	
	@Override
	public int getMove(IBoard<T> board) {
		IBoard<T> tboard = board.copy();
		if(tboard.isFull()) {
			return 0;
		} else if(tboard.get(3, 5) == board.getDefaultElem()) {
			return 3;
		}
		
		for(int x = 0; x <tboard.getWidth(); x++) {
			if(canPlay(x, tboard) && isWinningMove(tboard, x)) {
				return x;
			}
		}
		return r.nextInt(tboard.getWidth());
	}
	/**
	 * Check if this move is the winning move
	 * 
	 * @param board
	 * @param x coordinate to place token
	 * @return true if winning move
	 */
	private boolean isWinningMove(IBoard<T> board, int x) {
		IBoard<T> tboard = board.copy();
		Rule<T> rule = new Rule<>();
		tboard.placeToken(x, t);
		if(rule.hasWonFour(tboard, t)) {
			return true;
		}
		return false;
	}
	/**
	 * Check if it is a valid move
	 * 
	 * @param x coordinate to place token
	 * @param board
	 * @return true if valid
	 */
	private boolean canPlay(int x, IBoard<T> board) {
		IBoard<T> tboard = board.copy();
		return tboard.placeToken(x, t);
	}
	
}
