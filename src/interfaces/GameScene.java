package interfaces;

import inf101.v18.fourinarow.IBoard;
import inf101.v18.fourinarow.Token;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class GameScene extends Scene {
	IBoard board;

	public GameScene(Group g, double x, double y, Paint color, IBoard board) {
		super(g, x, y, color);
		this.board = board;
		
		printScene(g);
	}
	
	public void printScene(Group g) {
		for(int y = 0; y < board.getHeight(); y++) {
			for(int x = 0; x < board.getWidth(); x++) {
				if(board.getToken(x, y) == Token.BLANK) {
					Circle c = new Circle(x*100+50, y*100+50, 40, Color.WHITE);
					g.getChildren().add(c);
				} else if(board.getToken(x, y) == Token.YELLOW) {
					Circle c = new Circle(x*100+50, y*100+50, 40, Color.YELLOW);
					g.getChildren().add(c);
				} else if(board.getToken(x, y) == Token.RED) {
					Circle c = new Circle(x*100+50, y*100+50, 40, Color.RED);
					g.getChildren().add(c);
				}
			}
		}
	}
	


}
