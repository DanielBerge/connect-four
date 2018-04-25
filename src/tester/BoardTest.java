package tester;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.IBoard;
import game.Token;


class BoardTest {
	/**
	 * Place token in a board
	 * Check if token ends up at the right x,y coordinate
	 * Check that the other spots is blank
	 */
	@Test
	void placeTokenTest() {
		IBoard<Token> board = new Board<>(1, 7, Token.BLANK);
		board.placeToken(0, Token.RED);
		
		assertEquals(Token.RED, board.get(0, 6));
		
		for(int i = 0; i<5; i++) {
			assertEquals(Token.BLANK, board.get(0, i));
		}
	}
	/**
	 * Place two tokens in a board
	 * Check if tokens ends up at the right x,y coordinate
	 * Check that the other spots is blank
	 */
	
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
	/**
	 * Check if getToken works
	 */
	
	@Test
	void getTokenTest() {
		IBoard<Token> board = new Board<>(2,2, Token.BLANK);
		for(int x = 0; x < 2; x++) {
			for(int y = 0; y < 2; y++) {
				assertEquals(Token.BLANK, board.get(x, y));
			}
		}
	}
	/**
	 * Check if getting a token outside grid, returns null
	 */
	@Test
	void getTokenNullTest() {
		IBoard<Token> board = new Board<>(2,2, Token.BLANK);
		assertNull(board.get(-3, 6));
	}
	/**
	 * Fill board with tokens
	 * Check if board is full
	 */
	@Test
	void boardFullTest() {
		IBoard<Token> board = new Board<>(7,6, Token.BLANK);
		for(int x = 0; x < board.getWidth(); x++) {
			for(int y = 0; y < board.getHeight(); y++) {
				board.set(x, y, Token.RED);
			}
		}
		assertTrue(board.isFull());
	}
	/**
	 * Check if board is empty with isEmpty() method
	 */
	@Test
	void boardEmptyTest() {
		IBoard<Token> board = new Board<>(7,6, Token.BLANK);
		assertTrue(board.isEmpty());
	}
	/**
	 * Make a board, and put tokens in it
	 * Make a copy, and check if they are the same
	 */
	@Test
	public void copyTest() {
		IBoard<Token> board = new Board<>(7, 6, Token.BLANK);

		board.set(4, 4, Token.RED);

		IBoard<Token> newBoard = board.copy();
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				assertEquals(board.get(x, y), newBoard.get(x, y));
			}
		}
	}
}
