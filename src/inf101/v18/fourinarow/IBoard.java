package inf101.v18.fourinarow;

import grid.IGrid;

public interface IBoard extends IGrid<Token> {
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
	Token getToken(int x, int y);
	/**
	 * 
	 * @param x places at this x coordinate
	 * @param t which token to place
	 * @return if succeeds or not
	 */
	boolean placeToken(int x, Token t);

}
