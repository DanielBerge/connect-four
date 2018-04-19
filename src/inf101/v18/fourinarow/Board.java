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
	public boolean placeToken(int x, Token t) {
		for(int y = getHeight(); y >= 0; y--) {
			if(getToken(x,y) == Token.BLANK) {
				setToken(x,y,t);
				return true;
			}
		}
		return false;
	}

	@Override
	public void set(int x, int y, Token element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Token get(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGrid<Token> copy() {
		// TODO Auto-generated method stub
		return null;
	}
}
