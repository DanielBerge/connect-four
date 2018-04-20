package interfaces;

import board.IBoard;
import javafx.scene.Group;
import javafx.scene.Scene;
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
					Circle c = new Circle(x*100+50, y*100+50, 40, board.getToken(x, y).getColor());
					g.getChildren().add(c);
			}
		}
	}
}
