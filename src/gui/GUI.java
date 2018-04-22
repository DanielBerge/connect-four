package gui;

import game.Token;
import game.TurnHandler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import player.AI;

public class GUI extends Application {
	private static GameScene game;
	private static Group gameGroup = new Group();
	private static TurnHandler handler;

	@Override
	public void start(Stage primaryStage) throws Exception {
		StartScene startScene = new StartScene(new Group(), 400, 800, Color.BLUE, primaryStage);
		primaryStage.setTitle("Four in a row");
		primaryStage.initStyle(StageStyle.UTILITY);
		primaryStage.setScene(startScene);
		primaryStage.show();
	}

	protected static Scene startGame(AI<Token> ai) {
		handler = new TurnHandler(ai);
		game = new GameScene(gameGroup, 700, 675, Color.BLUE, handler.getBoard());

		handler.turn();
		return game;
	}
	
	public static GameScene getGameScene() {
		return game;
	}
	
	public static TurnHandler getHandler() {
		return handler;
	}

	public static void main(String args[]) {
		launch(args);
	}
}
