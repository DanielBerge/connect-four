package gui;

import java.util.Random;

import board.Board;
import board.IBoard;
import inf101.v18.extras.Rules;
import inf101.v18.extras.Token;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import player.AI;
import player.Human;
import player.IPlayer;

public class GUI extends Application {
	private static int width = 7;
	private static int height = 6;
	private static IBoard<Token> board = new Board<>(width, height, Token.BLANK);
	private static Random r = new Random();
	protected static Token turn = null;
	private static GameScene game;
	private static Group gameGroup = new Group();
	private static IPlayer<Token> red;
	private static IPlayer<Token> yellow;
	private static boolean won = false;

	@Override
	public void start(Stage primaryStage) throws Exception {
		StartScene startScene = new StartScene(new Group(), 400, 800, Color.BLUE, primaryStage);
		primaryStage.setTitle("Four in a row");
		primaryStage.setScene(startScene);
		primaryStage.show();
	}

	protected static Scene startGame(AI<Token> ai) {
		if (ai == null) {
			red = new Human<>(Token.RED);
			yellow = new Human<>(Token.YELLOW);
		} else {
			red = new Human<>(Token.RED);
			yellow = new AI<>(Token.YELLOW);
		}

		if (r.nextInt(2) == 0) {
			turn = red.getToken();
		} else {
			turn = yellow.getToken();
		}

		game = new GameScene(gameGroup, 700, 675, Color.BLUE, board);
		turn();
		return game;
	}

	private static void turn() {
		if (Rules.hasWonFour(board, turn)) {
			game.updateText(turn.getName() + " WON!");
			won = true;
			return;
		}
		if(board.isFull()) {
			game.updateText("Board full, it's a tie");
			won = true;
			return;
		}
		
		if (turn == red.getToken()) {
			turn = yellow.getToken();
			if (yellow.isAi()) {
				int i = yellow.getMove(board);
				while (!board.placeToken(i, turn)) {
					i = yellow.getMove(board);
				}
				turn();
			}
		} else {
			turn = red.getToken();
		}
		game.updateText(turn.getName() + "'s turn");
	}

	protected static void clicked(int i) {
		if (!won) {
			if (board.placeToken(i, turn)) {
				game.printScene();
				turn();
			} else {
				game.printScene();
				game.updateText("Column full, still " + turn.getName().toLowerCase() + "'s turn");
			}
		} else {
			game.printScene();
		}
	}

	public static void main(String args[]) {
		launch(args);
	}
}
