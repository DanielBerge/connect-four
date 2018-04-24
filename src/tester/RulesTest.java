package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.IBoard;
import game.Rules;
import game.Token;

class RulesTest {

	// Vertical
	@Test
	void RuleTest() {
		IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
		Rules<Token> rule = new Rules<>();
		for (int i = 0; i < 4; i++)
			board.placeToken(0, Token.RED);
		assertTrue(rule.hasWonFour(board, Token.RED));
	}

	// Horizontal
	@Test
	void RuleTest2() {
		IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
		Rules<Token> rule = new Rules<>();
		for (int i = 0; i < 4; i++)
			board.placeToken(i, Token.YELLOW);
		assertTrue(rule.hasWonFour(board, Token.YELLOW));
	}

	// Diagonal
	@Test
	void RuleTest3() {
		IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
		Rules<Token> rule = new Rules<>();
		for (int i = 0; i < 4; i++)
			board.set(i, i, Token.RED);
		assertTrue(rule.hasWonFour(board, Token.RED));
	}

	// Diagonal
	@Test
	void RuleTest4() {
		IBoard<Token> board = new Board<>(4, 4, Token.BLANK);
		Rules<Token> rule = new Rules<>();
		for (int i = 0; i < 4; i++)
			board.set(i, 3 - i, Token.YELLOW);
		assertTrue(rule.hasWonFour(board, Token.YELLOW));
	}

}
