package board;

import grid.MyGrid;

public class Board<T> extends MyGrid<T> implements IBoard<T> {
	private T blankElem;
	
	public Board(int width, int height, T blankElem) {
		super(width, height, blankElem);
		this.blankElem = blankElem;
	}
	
	@Override
	public T getToken(int x, int y) {
		if(x < 0 || x >= width)
			return null;
		if(y < 0 || y >= height)
			return null;
		return super.get(x, y);
	}

	@Override
	public boolean placeToken(int x, T elem) {
		for(int y = getHeight(); y >= 0; y--) {
			if(getToken(x,y) == blankElem) {
				set(x,y,elem);
				return true;
			}
		}
		return false;
	}

}
