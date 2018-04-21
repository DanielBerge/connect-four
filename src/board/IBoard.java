package board;

import grid.IGrid;

public interface IBoard<T> extends IGrid<T> {
	/**
	 * Place an element at the bottom of the grid
	 * 
	 * @param x place element at this x coordinate
	 * @param t which token to place
	 * @return if succeeds or not
	 */
	boolean placeToken(int x, T t);
}
