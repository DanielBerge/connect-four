package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.ITurnHandler;
import game.Token;
import game.TurnHandler;
import gui.GUI;
import gui.GameScene;
import player.Human;
import player.IPlayer;

class TurnTest {
	/**
	 * Create turnhandler
	 * Check that turn is not null
	 */
	@Test
	void notNullTest() {
		IPlayer<Token> h1 = new Human<>(Token.RED);
		IPlayer<Token> h2 = new Human<>(Token.YELLOW);
		
		ITurnHandler handler = new TurnHandler(h1,h2);
		IPlayer<Token> turn = handler.getTurn();
		assertNotNull(turn);
	}

}
