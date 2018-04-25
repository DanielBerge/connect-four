package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}
