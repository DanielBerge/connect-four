package inf101.v18.fourinarow;

public class Player {
	private Token t;
	private String name;
	
	public Player(Token t, String name) {
		this.t = t;
		this.name = name;
	}
	
	public Token getToken() {
		return t;
	}
	
	public String getName() {
		return name;
	}

}
