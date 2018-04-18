package inf101.v18.fourinarow;

import grid.IGrid;
import grid.MyGrid;

public class Board implements IBoard {
	private IGrid<Token> grid;
	private int height;
	private int width;
	
	public Board(int width, int height) {
		if(width <= 0 || height <= 0)
			throw new IllegalArgumentException();
		this.height = height;
		this.width = width;
		this.grid = new MyGrid<Token>(width, height, Token.BLANK);
	}
	
	@Override
	public void setToken(int x, int y, Token t) {
		grid.set(x, y, t);
	}
	
	@Override
	public Token getToken(int x, int y) {
		if(x < 0 || x >= width)
			return null;
		if(y < 0 || y >= height)
			return null;
		return grid.get(x, y);
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public void placeToken(int x, Token t) {
		for(int y = 0; y < getHeight(); y++) {
			if(getToken(x,y) == Token.BLANK) {
				setToken(x,y,t);
				return;
			}
		}
		System.out.println("Row full");
	}
}
