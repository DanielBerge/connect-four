package inf101.v18.fourinarow;

import interfaces.TextInterface;

public class Game {
	private static int width = 7;
	private static int height = 6;
	
	public static void main(String[] args) {
		IBoard board = new Board(width, height);
		TextInterface interf = new TextInterface(board);
	}
}
