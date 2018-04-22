package gui;

import board.IBoard;
import game.Token;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameScene extends Scene {
	private IBoard<Token> board;
	private Text txt;
	private Group g;
	Circle c;

	public GameScene(Group g, double x, double y, Paint color, IBoard<Token> board) {
		super(g, x, y, color);
		this.board = board;
		this.g = g;
		this.setCursor(Cursor.CROSSHAIR);
		printScene();
		txt = new Text(10, 650, GUI.turn.getName() + "'s turn");
		txt.setFont(Font.font(null, FontWeight.BOLD, 32));
		txt.setFill(Color.WHITE);
		g.getChildren().add(txt);
	}

	public void printScene() {
		for (int y = 0; y < board.getHeight(); y++) {
			for (int x = 0; x < board.getWidth(); x++) {
				Circle c = new Circle(x * 100 + 50, y * 100 + 50, 40, board.get(x, y).getColor());
				g.getChildren().add(c);
			}
		}
		makeButtons();
	}
	
	protected void updateText(String s) {
		txt.setText(s);
	}
	
	
	private void makeButtons() {
		Button b1 = new Button();
		b1.setMinSize(100, 700);
		b1.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b1);
		b1.setOnAction(e -> GUI.clicked(0));
		b1.setOnMouseEntered(e -> makeCircle(0));
		b1.setOnMouseExited(e -> c.setFill(Color.TRANSPARENT));

		Button b2 = new Button();
		b2.setMinSize(100, 700);
		b2.setLayoutX(100);
		b2.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b2);
		b2.setOnAction(e -> GUI.clicked(1));
		b2.setOnMouseEntered(e -> makeCircle(1));
		b2.setOnMouseExited(e -> c.setFill(Color.TRANSPARENT));

		Button b3 = new Button();
		b3.setMinSize(100, 700);
		b3.setLayoutX(200);
		b3.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b3);
		b3.setOnAction(e -> GUI.clicked(2));
		b3.setOnMouseEntered(e -> makeCircle(2));
		b3.setOnMouseExited(e -> c.setFill(Color.TRANSPARENT));

		Button b4 = new Button();
		b4.setMinSize(100, 700);
		b4.setLayoutX(300);
		b4.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b4);
		b4.setOnAction(e -> GUI.clicked(3));
		b4.setOnMouseEntered(e -> makeCircle(3));
		b4.setOnMouseExited(e -> c.setFill(Color.TRANSPARENT));

		Button b5 = new Button();
		b5.setMinSize(100, 700);
		b5.setLayoutX(400);
		b5.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b5);
		b5.setOnAction(e -> GUI.clicked(4));
		b5.setOnMouseEntered(e -> makeCircle(4));
		b5.setOnMouseExited(e -> c.setFill(Color.TRANSPARENT));

		Button b6 = new Button();
		b6.setMinSize(100, 700);
		b6.setLayoutX(500);
		b6.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b6);
		b6.setOnAction(e -> GUI.clicked(5));
		b6.setOnMouseEntered(e -> makeCircle(5));
		b6.setOnMouseExited(e -> c.setFill(Color.TRANSPARENT));

		Button b7 = new Button();
		b7.setMinSize(100, 700);
		b7.setLayoutX(600);
		b7.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b7);
		b7.setOnAction(e -> GUI.clicked(6));
		b7.setOnMouseEntered(e -> makeCircle(6));
		b7.setOnMouseExited(e -> c.setFill(Color.TRANSPARENT));
	}
	
	private void makeCircle(int i) {
		c = new Circle(i * 100 + 50, 0, 40, GUI.turn.getColor());
		g.getChildren().add(c);
	}
}
