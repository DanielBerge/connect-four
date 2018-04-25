package board;

import grid.MyGrid;

public class Board<T> extends MyGrid<T> implements IBoard<T> {
	private T defaultElem;
	/**
	 * Construct a board with the given dimensions.
	 * 
	 * @param width
	 * @param height
	 * @param defaultElem what the board should initially hold
	 */
	public Board(int width, int height, T defaultElem) {
		super(width, height, defaultElem);
		this.defaultElem = defaultElem;
	}

	@Override
	public boolean placeToken(int x, T elem) {
		for (int y = getHeight(); y >= 0; y--) {
			if (get(x, y) == defaultElem) {
				set(x, y, elem);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean isFull() {
		for(int x = 0; x < this.getWidth(); x++) {
			for(int y = 0; y < this.getHeight(); y++) {
				if(this.get(x, y) == defaultElem)
					return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean isEmpty() {
		for(int x = 0; x < this.getWidth(); x++) {
			for(int y = 0; y < this.getHeight(); y++) {
				if(this.get(x, y) != defaultElem)
					return false;
			}
		}
		return true;
	}
	
	@Override
	public T getDefaultElem() {
		return defaultElem;
	}
	
	@Override
	public IBoard<T> copy() {
		Board<T> newGrid = new Board<>(getWidth(), getHeight(), getDefaultElem());
		for (int x = 0; x < width; x++)
			for(int y = 0; y < height; y++)
				newGrid.set(x,  y,  get(x, y));
		return newGrid;
	}

}
