package player;

import java.util.Random;
import board.IBoard;
import game.Rule;
import game.Token;

public class AI<T extends Token> extends AbstractPlayer<T> {
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
		
		//Sjekker om det er mulig å vinne
		for(int x = 0; x <tboard.getWidth(); x++) {
			if(canPlay(x, tboard) && isWinningMove(tboard, x)) {
				return x;
			}
		}
		
		//Sjekker om den andre spilleren kan vinne, så den kan stoppes
		//for(int x = 0; x)

		return r.nextInt(tboard.getWidth());
	}
	
	private boolean isWinningMove(IBoard<T> board, int x) {
		IBoard<T> tboard = board.copy();
		Rule<T> rule = new Rule<>();
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
