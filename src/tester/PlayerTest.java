package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.IBoard;
import game.Token;
import player.AI;
import player.Human;
import player.IPlayer;

class PlayerTest {
	/**
	 * Checks that the get methods returns token.
	 * Checks that player isAi equals false
	 */
	@Test
	void getTokenHumanTest() {
		IPlayer<Token> player = new Human<>(Token.RED);
		assertEquals(Token.RED, player.getToken());
		assertFalse(player.isAi());
	}
	/**
	 * Checks that the get methods returns token.
	 * Checks that player isAi equals true
	 */
	@Test
	void GetTokenAITest() {
		IPlayer<Token> ai = new AI<>(Token.YELLOW);
		assertEquals(Token.YELLOW, ai.getToken());
		assertTrue(ai.isAi());
	}
	/**
	 * Checks if getMove returns 0 if board is full
	 */
	@Test
	void boardFullPlayTest() {
		for(int i = 0; i < 100; i++) {
			IPlayer<Token> ai = new AI<>(Token.YELLOW);
			IBoard<Token> board = new Board<>(2, 2, Token.BLANK);
			board.placeToken(1, Token.RED);
			board.placeToken(1, Token.RED);
			board.placeToken(0, Token.RED);
			board.placeToken(0, Token.RED);
			assertEquals(0, ai.getMove(board));
		}
	}
	/**
	 * Checks if AI does winning move if it can
	 */
	@Test
	void correctPlayTest() {
		for(int i = 0; i < 100; i++) {
			IPlayer<Token> ai = new AI<>(Token.YELLOW);
			IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
			board.placeToken(0, Token.YELLOW);
			board.placeToken(1, Token.YELLOW);
			board.placeToken(2, Token.YELLOW);
			assertEquals(3, ai.getMove(board));
		}
	}
	/**
	 * Checks if it does correct first move every time it can
	 */
	@Test
	void firstMoveTest() {
		for(int i = 0; i < 100; i++) {
			IPlayer<Token> ai = new AI<>(Token.YELLOW);
			IBoard<Token> board = new Board<>(7, 6, Token.BLANK);
			assertEquals(3, ai.getMove(board));
		}
	}
	

}
