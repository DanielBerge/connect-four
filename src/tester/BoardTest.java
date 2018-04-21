package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.IBoard;
import inf101.v18.extras.Token;

class BoardTest {

	@Test
	void placeTokenTest() {
		IBoard<Token> board = new Board<>(1, 7, Token.BLANK);
		board.placeToken(0, Token.RED);
		
		assertEquals(Token.RED, board.get(0, 6));
		
		for(int i = 0; i<5; i++) {
			assertEquals(Token.BLANK, board.get(0, i));
		}
	}
	
	@Test
	void placeTokenTest2() {
		IBoard<Token> board = new Board<>(1, 7, Token.BLANK);
		board.placeToken(0, Token.YELLOW);
		board.placeToken(0, Token.RED);
		
		assertEquals(Token.YELLOW, board.get(0, 6));
		assertEquals(Token.RED, board.get(0, 5));
		
		for(int i = 0; i<4; i++) {
			assertEquals(Token.BLANK, board.get(0, i));
		}
	}
	
	@Test
	void getTokenTest() {
		IBoard<Token> board = new Board<>(2,2, Token.BLANK);
		for(int x = 0; x < 2; x++) {
			for(int y = 0; y < 2; y++) {
				assertEquals(Token.BLANK, board.get(x, y));
			}
		}
	}
	
	@Test
	void getTokenNullTest() {
		IBoard<Token> board = new Board<>(2,2, Token.BLANK);
		assertNull(board.get(-3, 6));
	}
}
