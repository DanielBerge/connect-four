package inf101.v18.fourinarow;

public abstract class AbstractPlayer {
	protected Token t;
	
	public AbstractPlayer(Token t) {
		this.t = t;
	}
	
	public Token getToken() {
		return t;
	}
	
	public boolean isAi() {
		return false;
	}

	public int getMove(IBoard board) {
		return 0;
	}

}
