package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import inf101.v18.extras.Token;
import player.AI;
import player.Human;
import player.IPlayer;

class PlayerTest {

	@Test
	void getTokenTest() {
		IPlayer<Token> player = new Human<Token>(Token.RED);
		assertEquals(Token.RED, player.getToken());
		assertFalse(player.isAi());
	}
	
	@Test
	void AITest() {
		IPlayer<Token> ai = new AI<Token>(Token.YELLOW);
		assertTrue(ai.isAi());
	}

}
