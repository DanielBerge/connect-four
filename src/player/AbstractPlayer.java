package player;

import board.IBoard;

public abstract class AbstractPlayer<T> implements IPlayer<T> {
	protected T t;

	public AbstractPlayer(T t) {
		this.t = t;
	}

	@Override
	public T getToken() {
		return t;
	}

	@Override
	public boolean isAi() {
		return false;
	}

	@Override
	public int getMove(IBoard<T> board, T elem) {
		return 0;
	}

}
