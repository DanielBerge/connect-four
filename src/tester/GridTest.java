package tester;


import java.util.Random;

import game.Token;
import grid.IGrid;
import grid.MyGrid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GridTest {
	Random random = new Random();
	/**
	 * Checks if grid is constructed with the right dimensions
	 */
	@Test
	public void constructTest1() {
		IGrid<Token> grid = new MyGrid<>(11, 17, Token.BLANK);
		assertEquals(11, grid.getWidth());
		assertEquals(17, grid.getHeight());
	}
	/**
	 * Tests that trying to access outside of the dimensions of the grid throws an
	 * IndexOutOfBoundsException.
	 */
	@Test
	public void outOfBoundsTest1() {
		IGrid<Token> grid = new MyGrid<>(10, 10, Token.BLANK);

		try {
			grid.set(11, -4, Token.BLANK);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.set(-4, 11, Token.BLANK);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}

	}

	/**
	 * Tests that trying to access outside of the dimensions of the grid throws an
	 * IndexOutOfBoundsException.
	 */
	@Test
	public void outOfBoundsTest2() {
		IGrid<Token> grid = new MyGrid<>(10, 10, Token.BLANK);

		try {
			grid.set(11, 0, Token.BLANK);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.set(0, 11, Token.BLANK);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
	}
	/**
	 * Tests that set and get works
	 */
	@Test
	public void setGetTest1() {
		IGrid<Token> grid = new MyGrid<>(100, 100, Token.BLANK);

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, Token.YELLOW);
				assertEquals(Token.YELLOW, grid.get(x, y));
			}
	}
	/**
	 * Tests that set and get works
	 */
	@Test
	public void setGetTest2() {
		IGrid<Token> grid = new MyGrid<>(100, 100, Token.BLANK);

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, Token.RED);
			}
		}

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, Token.RED);
				assertEquals(Token.RED, grid.get(x, y));
			}
	}
}
