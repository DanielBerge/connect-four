package gui;

import game.Token;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import player.AI;
import player.Human;
import player.IPlayer;

public class StartScene extends Scene {
	private Button start;
	private Button startai;

	public StartScene(Group g, double x, double y, Paint color, Stage primaryStage) {
		super(g, x, x, color);
		this.getStylesheets().addAll("stylesheet.css");
		makeInstances(g);
		IPlayer<Token> h1 = new Human<>(Token.RED);
		IPlayer<Token> h2 = new Human<>(Token.YELLOW);
		IPlayer<Token> ai1 = new AI<>(Token.YELLOW);
		
		start.setOnAction(e -> primaryStage.setScene(GUI.startGame(h1, h2)));
		startai.setOnAction(e -> {
			primaryStage.setScene(GUI.startGame(h1, ai1));
		});
	}
	
	private void makeInstances(Group g) {
		g.setId("pane");
		Text txt = new Text("Four in a row");
		txt.setFont(Font.font("Roboto", FontWeight.BOLD, 32));
		txt.setFill(Color.ALICEBLUE);
		txt.getStyleClass().add("txt");
		txt.setLayoutX(47);
		txt.setLayoutY(50);
		
		start = new Button("Human VS Human");
		start.setMinSize(300, 100);
		start.setLayoutX(50);
		start.setLayoutY(100);
		start.setFocusTraversable(false);


		startai = new Button("Human VS AI");
		startai.setMinSize(300, 100);
		startai.setLayoutX(50);
		startai.setLayoutY(230);
		startai.setFocusTraversable(false);

		g.getChildren().add(txt);
		g.getChildren().add(start);
		g.getChildren().add(startai);
	}
	
	public Button getStartAiButton() {
		return startai;
	}
	
	public Button getStartButton() {
		return start;
	}

}
