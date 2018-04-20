package tester;

import static org.junit.Assert.*;


import java.util.Random;

import org.junit.Test;

import grid.IGrid;
import grid.MyGrid;

import inf101.v18.extras.Token;

public class GridTest {
	Random random = new Random();

	@Test
	public void constructTest1() {
		IGrid<Token> grid = new MyGrid<Token>(11, 17, Token.BLANK);
		assertEquals(11, grid.getWidth());
		assertEquals(17, grid.getHeight());
	}
	
	@Test
	public void outOfBoundsTest1() {
		IGrid<Token> grid = new MyGrid<Token>(10, 10, Token.BLANK);
		
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
	 * Tests that trying to access outside of the dimensions of the grid throws
	 * an IndexOutOfBoundsException.
	 */
	@Test
	public void outOfBoundsTest2() {
		IGrid<Token> grid = new MyGrid<Token>(10, 10, Token.BLANK);

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

	@Test
	public void setGetTest1() {
		IGrid<Token> grid = new MyGrid<Token>(100, 100, Token.BLANK);

		for (int x = 0; x < 100; x++)
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, Token.YELLOW);
				assertEquals(Token.YELLOW, grid.get(x, y));
			}
	}

	@Test
	public void setGetTest2() {
		IGrid<Token> grid = new MyGrid<Token>(100, 100, Token.BLANK);

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

	@Test
	public void copyTest() {
		IGrid<Token> grid = new MyGrid<Token>(100, 100, Token.BLANK);

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				grid.set(x, y, Token.RED);
			}
		}

		IGrid<Token> newGrid = grid.copy();
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				assertEquals(grid.get(x, y), newGrid.get(x, y));
			}
		}
	}
}
