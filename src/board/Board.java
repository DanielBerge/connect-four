package board;

import grid.MyGrid;
import inf101.v18.extras.Token;

public class Board extends MyGrid<Token> implements IBoard {
	
	public Board(int width, int height) {
		super(width, height, Token.BLANK);
	}
	
	@Override
	public Token getToken(int x, int y) {
		if(x < 0 || x >= width)
			return null;
		if(y < 0 || y >= height)
			return null;
		return super.get(x, y);
	}

	@Override
	public boolean placeToken(int x, Token t) {
		for(int y = getHeight(); y >= 0; y--) {
			if(getToken(x,y) == Token.BLANK) {
				set(x,y,t);
				return true;
			}
		}
		return false;
	}

}
