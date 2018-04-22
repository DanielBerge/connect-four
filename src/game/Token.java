package game;

import javafx.scene.paint.Color;

public class Token {
	public static final Token BLANK = new Token(Color.BLUE.darker(), "Blank");
	public static final Token RED = new Token(Color.RED, "Red");
	public static final Token YELLOW = new Token(Color.YELLOW, "Yellow");

	private Color color;
	private String name;

	public Token(Color color, String name) {
		this.color = color;
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public String getName() {
		return name;
	}
}
