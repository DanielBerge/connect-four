package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Token;
import player.AI;
import player.Human;
import player.IPlayer;

class PlayerTest {

	@Test
	void getTokenTest() {
		IPlayer<Token> player = new Human<>(Token.RED);
		assertEquals(Token.RED, player.getToken());
		assertFalse(player.isAi());
	}

	@Test
	void AITest() {
		IPlayer<Token> ai = new AI<>(Token.YELLOW);
		assertTrue(ai.isAi());
	}

}
