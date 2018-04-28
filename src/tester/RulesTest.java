package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.IBoard;
import game.Rule;
import game.Token;

class RulesTest {

	/**
	 * Vertical test
	 * Place four tokens in a row
	 * Check if won
	 */
	@Test
	void RuleTest() {
		for (int i = 0; i < 100; i++) {
			IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
			Rule<Token> rule = new Rule<>();
			for (int x = 0; x < 4; x++)
				board.placeToken(0, Token.RED);
			assertTrue(rule.hasWonFour(board, Token.RED));
		}
	}

	/**
	 *  Horizontal test
	 *  Place four tokens in a row
	 *  Check if won
	 */
	@Test
	void RuleTest2() {
		for (int i = 0; i < 100; i++) {
			IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
			Rule<Token> rule = new Rule<>();
			for (int x = 0; x < 4; x++)
				board.placeToken(x, Token.YELLOW);
			assertTrue(rule.hasWonFour(board, Token.YELLOW));
		}
	}

	/** 
	 * Diagonal test, from left to right upwards
	 */
	@Test
	void RuleTest3() {
		for (int i = 0; i < 100; i++) {
			IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
			Rule<Token> rule = new Rule<>();
			for (int x = 0; x < 4; x++)
				board.set(x, x, Token.RED);
			assertTrue(rule.hasWonFour(board, Token.RED));
		}
	}

	/**
	 * Diagonal test, from right to left upwards
	 */
	@Test
	void RuleTest4() {
		for (int i = 0; i < 100; i++) {
			IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
			Rule<Token> rule = new Rule<>();
			for (int x = 0; x < 4; x++)
				board.set(x, 3 - x, Token.YELLOW);
			assertTrue(rule.hasWonFour(board, Token.YELLOW));
		}
	}

}
