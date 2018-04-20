package interfaces;

import java.util.Random;

import inf101.v18.fourinarow.AI;
import inf101.v18.fourinarow.Board;
import inf101.v18.fourinarow.Game;
import inf101.v18.fourinarow.Human;
import inf101.v18.fourinarow.IBoard;
import inf101.v18.fourinarow.AbstractPlayer;
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
	private Stage window;
	private GameScene game;
	private Group gameGroup = new Group();
	private Text gameText = new Text();
	AbstractPlayer red;
	AbstractPlayer yellow;
	private boolean won = false;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Group g = new Group();
	    Scene scene = new Scene(g, 600, 300, Color.WHITE);
		
		window = primaryStage;
		Button start = new Button("Human VS Human");
		start.setMinSize(300, 150);
		
		Button startai = new Button("Human VS AI");
		startai.setMinSize(300, 150);
		startai.setLayoutX(300);
		
		g.getChildren().add(start);
		g.getChildren().add(startai);
		
	    start.setOnAction(e -> window.setScene(startGame(null)));
	    startai.setOnAction(e -> {
	    	AI player = new AI(Token.RED);
	    	window.setScene(startGame(player));
	    });
		
		window.setTitle("Four in a row");
		window.setScene(scene);
		window.show();
	}

	public Scene startGame(AI ai) {
		if(ai == null) {
			red = new Human(Token.RED);
			yellow = new Human(Token.YELLOW);
		} else {
			red = new Human(Token.RED);
			yellow = new AI(Token.YELLOW);
		}
		
		if(r.nextInt(2) == 0) {
			turn = red.getToken();
		} else {
			turn = yellow.getToken();
		}
		
		this.game = new GameScene(gameGroup, 700, 700, Color.BLUE, board);
		game.printScene(gameGroup);
		makeButtons();
		turn();
		gameText = new Text(10, 650, turn.getName() + " sin tur");
		gameText.setFont(Font.font(null, FontWeight.BOLD, 32));
		gameText.setFill(Color.WHITE);
		gameGroup.getChildren().add(gameText);
		
		return game;
	}
	
	public void turn() {
		if(Rules.hasWonFour(board, turn)) {
			updateText(turn.getName() + " VANT!!!!!!!!");
			won = true;
			return;
		}
		if(turn == red.getToken()) {
			turn = yellow.getToken();
			if(yellow.isAi()) {
				int i = yellow.getMove(board);
				while(!board.placeToken(i, turn)) {
					i = yellow.getMove(board);
				}
				turn();
			}
		} else {
			turn = red.getToken();
		}
		updateText(turn.getName() + " sin tur");
	}
	
	private void clicked(int i) {
		if(!won) {
			if(board.placeToken(i, turn)) {
				game.printScene(gameGroup);
				makeButtons();
				turn();
			} else {
				game.printScene(gameGroup);
				makeButtons();
				updateText("Raden er full, fortsatt " + turn.getName().toLowerCase() + " sin tur");
			}
		} else {
			game.printScene(gameGroup);
		}
	}
	public void makeButtons() {
		Button b1 = new Button();
		b1.setMinSize(100, 700);
		b1.setStyle("-fx-background-color: transparent;");
		gameGroup.getChildren().add(b1);
		b1.setOnAction(e -> clicked(0));
		
		Button b2 = new Button();
		b2.setMinSize(100, 700);
		b2.setLayoutX(100);
		b2.setStyle("-fx-background-color: transparent;");
		gameGroup.getChildren().add(b2);
		b2.setOnAction(e -> clicked(1));
		
		Button b3 = new Button();
		b3.setMinSize(100, 700);
		b3.setLayoutX(200);
		b3.setStyle("-fx-background-color: transparent;");
		gameGroup.getChildren().add(b3);
		b3.setOnAction(e -> clicked(2));
		
		Button b4 = new Button();
		b4.setMinSize(100, 700);
		b4.setLayoutX(300);
		b4.setStyle("-fx-background-color: transparent;");
		gameGroup.getChildren().add(b4);
		b4.setOnAction(e -> clicked(3));
		
		Button b5 = new Button();
		b5.setMinSize(100, 700);
		b5.setLayoutX(400);
		b5.setStyle("-fx-background-color: transparent;");
		gameGroup.getChildren().add(b5);
		b5.setOnAction(e -> clicked(4));
		
		Button b6 = new Button();
		b6.setMinSize(100, 700);
		b6.setLayoutX(500);
		b6.setStyle("-fx-background-color: transparent;");
		gameGroup.getChildren().add(b6);
		b6.setOnAction(e -> clicked(5));
		
		Button b7 = new Button();
		b7.setMinSize(100, 700);
		b7.setLayoutX(600);
		b7.setStyle("-fx-background-color: transparent;");
		gameGroup.getChildren().add(b7);
		b7.setOnAction(e -> clicked(6));
	}
	
	public void updateText(String s) {
		gameText.setText(s);
	}
	
	public static void main(String args[]){   
		   launch(args);      
	}
}
