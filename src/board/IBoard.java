package board;

import grid.IGrid;

public interface IBoard<T> extends IGrid<T> {
	/**
	 * @return The number of rows.
	 */
	int getHeight();
	/**
	 * @return The number of columns.
	 */
	int getWidth();
	/**
	 * @return The token in given x,y coordinates.
	 * @return null if outside map
	 */
	T getToken(int x, int y);
	/**
	 * 
	 * @param x places at this x coordinate
	 * @param t which token to place
	 * @return if succeeds or not
	 */
	boolean placeToken(int x, T t);
}
