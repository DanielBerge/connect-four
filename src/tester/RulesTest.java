package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import board.Board;
import board.IBoard;
import inf101.v18.extras.Rules;
import inf101.v18.extras.Token;

class RulesTest {

	//Vertikal
	@Test
	void RuleTest() {
		IBoard<Token> board = new Board<Token>(4,4, Token.BLANK);
		for(int i = 0; i < 4; i++)
			board.placeToken(0, Token.RED);
		assertTrue(Rules.hasWonFour(board, Token.RED));
	}
	
	//Horisontal
	@Test
	void RuleTest2() {
		IBoard<Token> board = new Board<Token>(4,4, Token.BLANK);
		for(int i = 0; i < 4; i++)
			board.placeToken(i, Token.YELLOW);
		assertTrue(Rules.hasWonFour(board, Token.YELLOW));
	}
	
	//Diagonal
	@Test
	void RuleTest3() {
		IBoard<Token> board = new Board<Token>(4,4, Token.BLANK);
		for(int i = 0; i < 4; i++)
			board.set(i, i, Token.RED);
		assertTrue(Rules.hasWonFour(board, Token.RED));
	}
	
	//Diagonal
	@Test
	void RuleTest4() {
		IBoard<Token> board = new Board<Token>(4,4, Token.BLANK);
		for(int i = 0; i < 4; i++)
			board.set(i, 3-i, Token.YELLOW);
		assertTrue(Rules.hasWonFour(board, Token.YELLOW));
	}
	

}
