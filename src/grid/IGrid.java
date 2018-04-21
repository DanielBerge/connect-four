package grid;

public interface IGrid<T> {

	/**
	 * @return The height of the grid.
	 */
	int getHeight();

	/**
	 * @return The width of the grid.
	 */
	int getWidth();

	/**
	 * 
	 * Set the contents of the cell in the given x,y location. 
	 * 
	 * y must be greater than or equal to 0 and less than getHeight().
	 * x must be greater than or equal to 0 and less than getWidth().
	 * 
	 * @param x The column of the cell to change the contents of.
	 * @param y The row of the cell to change the contents of.
	 * @param element The contents the cell is to have.
	 */
	void set(int x, int y, T element);

	/**
	 * 
	 * Get the contents of the cell in the given x,y location. 
	 * 
	 * y must be greater than or equal to 0 and less than getHeight().
	 * x must be greater than or equal to 0 and less than getWidth().
	 * 
	 * @param x The column of the cell to get the contents of.
	 * @param y The row of the cell to get contents of.
	 * 
	 * @return The token in given x,y coordinates.
	 * @return null if outside grid
	 */
	T get(int x, int y);
}