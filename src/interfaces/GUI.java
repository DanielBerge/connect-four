package interfaces;

import java.util.Random;

import inf101.v18.fourinarow.AI;
import inf101.v18.fourinarow.Board;
import inf101.v18.fourinarow.IBoard;
import inf101.v18.fourinarow.Player;
import inf101.v18.fourinarow.Rules;
import inf101.v18.fourinarow.Token;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
	private static int width = 7;
	private static int height = 6;
	private IBoard board = new Board(width, height);
	private Random r = new Random();
	private Token turn = null;
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		//Start game scene
		Button start = new Button("Start game");
		start.setMinSize(300, 150);
		Button startai = new Button("Start AI game");
		startai.setMinSize(300, 150);
		startai.setLayoutX(300);
		
		Group g = new Group();
		g.getChildren().add(start);
		g.getChildren().add(startai);
		
	    Scene scene = new Scene(g, 600, 300, Color.WHITE);
	    start.setOnAction(e -> primaryStage.setScene(startGame(primaryStage)));
	    startai.setOnAction(e -> primaryStage.setScene(startAiGame(primaryStage)));
		
	
		primaryStage.setTitle("Four in a row");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public Scene startGame(Stage primaryStage) {
		Group g = new Group();
		Scene game = new Scene(g, 700, 700, Color.BLUE);
		Rules rules = new Rules();
		
		//Printer ut selve brettet
		printScene(g);
		
		if(rules.hasWonFour(board, turn)) {
			updateText(g, turn);
			return game;
		}
		//buttons
		makeButtons(g, primaryStage);

		Player red = new Player(Token.RED, "Bjarne");
		Player yellow = new Player(Token.YELLOW, "Arne");
		
		if(turn == null) {
			if(r.nextInt(2) == 0) {
				turn = red.getToken();
			} else {
				turn = yellow.getToken();
			}
		}
		
		if(turn == red.getToken()) {
			turn = yellow.getToken();
		} else {
			turn = red.getToken();
		}
		
		updateText(g, turn);
		return game;
	}
	
	public Scene startAiGame(Stage primaryStage) {
		//Printer ut selve brettet
		Group g = new Group();
		printScene(g);
		//buttons
		makeButtons(g, primaryStage);
		
		//////
		Player yellow = new Player(Token.YELLOW, "Arne");
		AI red = new AI(Token.RED);
		
		if(turn == null) {
			if(r.nextInt(2) == 0) {
				turn = red.getToken();
			} else {
				turn = yellow.getToken();
			}
		}
		
		if(turn == red.getToken()) {
			turn = yellow.getToken();
		} else {
			turn = red.getToken();
			place(red.getMove(board), primaryStage);
		}
		
		
		Scene game = new Scene(g, 700, 700, Color.BLUE);
		return game;
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
	
	public void updateText(Group g, Token t) {
		Text txt = new Text(10, 650, t + " sin tur");
		txt.setFont(Font.font(null, FontWeight.BOLD, 32));
		txt.setFill(Color.WHITE);
		
		g.getChildren().add(txt);
	}
	

	
	public void makeButtons(Group g, Stage primaryStage) {
		Button b1 = new Button();
		b1.setMinSize(100, 700);
		b1.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b1);
		b1.setOnAction(e -> {
			board.placeToken(0, turn);
			primaryStage.setScene(startGame(primaryStage));
		});
		
		Button b2 = new Button();
		b2.setMinSize(100, 700);
		b2.setLayoutX(100);
		b2.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b2);
		b2.setOnAction(e -> {
			board.placeToken(1, turn);
			primaryStage.setScene(startGame(primaryStage));
		});
		
		Button b3 = new Button();
		b3.setMinSize(100, 700);
		b3.setLayoutX(200);
		b3.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b3);
		b3.setOnAction(e -> {
			board.placeToken(2, turn);
			primaryStage.setScene(startGame(primaryStage));
		});
		
		Button b4 = new Button();
		b4.setMinSize(100, 700);
		b4.setLayoutX(300);
		b4.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b4);
		b4.setOnAction(e -> {
			board.placeToken(3, turn);
			primaryStage.setScene(startGame(primaryStage));
		});
		
		Button b5 = new Button();
		b5.setMinSize(100, 700);
		b5.setLayoutX(400);
		b5.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b5);
		b5.setOnAction(e -> {
			board.placeToken(4, turn);
			primaryStage.setScene(startGame(primaryStage));
		});
		
		Button b6 = new Button();
		b6.setMinSize(100, 700);
		b6.setLayoutX(500);
		b6.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b6);
		b6.setOnAction(e -> {
			board.placeToken(5, turn);
			primaryStage.setScene(startGame(primaryStage));
		});
		
		Button b7 = new Button();
		b7.setMinSize(100, 700);
		b7.setLayoutX(600);
		b7.setStyle("-fx-background-color: transparent;");
		g.getChildren().add(b7);
		b7.setOnAction(e -> place(6, primaryStage));
	}
	
	public void place(int row, Stage primaryStage) {
		board.placeToken(row, turn);
		primaryStage.setScene(startGame(primaryStage));
	}
	
	public static void main(String args[]){   
		   launch(args);      
	}
}
