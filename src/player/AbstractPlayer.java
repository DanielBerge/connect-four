package player;

import board.IBoard;
import inf101.v18.extras.Token;

public abstract class AbstractPlayer implements IPlayer {
	protected Token t;
	
	public AbstractPlayer(Token t) {
		this.t = t;
	}
	
	@Override
	public Token getToken() {
		return t;
	}
	
	@Override
	public boolean isAi() {
		return false;
	}

	@Override
	public int getMove(IBoard board) {
		return 0;
	}

}
