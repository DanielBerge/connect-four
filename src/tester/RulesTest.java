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
		IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
		Rule<Token> rule = new Rule<>();
		for (int i = 0; i < 4; i++)
			board.placeToken(0, Token.RED);
		assertTrue(rule.hasWonFour(board, Token.RED));
	}

	/**
	 *  Horizontal test
	 *  Place four tokens in a row
	 *  Check if won
	 */
	@Test
	void RuleTest2() {
		IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
		Rule<Token> rule = new Rule<>();
		for (int i = 0; i < 4; i++)
			board.placeToken(i, Token.YELLOW);
		assertTrue(rule.hasWonFour(board, Token.YELLOW));
	}

	/** 
	 * Diagonal test, from left to right upwards
	 */
	@Test
	void RuleTest3() {
		IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
		Rule<Token> rule = new Rule<>();
		for (int i = 0; i < 4; i++)
			board.set(i, i, Token.RED);
		assertTrue(rule.hasWonFour(board, Token.RED));
	}

	/**
	 * Diagonal test, from right to left upwards
	 */
	@Test
	void RuleTest4() {
		IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
		Rule<Token> rule = new Rule<>();
		for (int i = 0; i < 4; i++)
			board.set(i, 3 - i, Token.YELLOW);
		assertTrue(rule.hasWonFour(board, Token.YELLOW));
	}

}
