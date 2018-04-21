package gui;

import inf101.v18.extras.Token;
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

public class StartScene extends Scene {
	private Button start;
	private Button startai;

	public StartScene(Group g, double x, double y, Paint color, Stage primaryStage) {
		super(g, x, x, color);
		this.getStylesheets().addAll("stylesheet.css");
		makeInstances(g);
		start.setOnAction(e -> primaryStage.setScene(GUI.startGame(null)));
		startai.setOnAction(e -> {
			AI<Token> player = new AI<>(Token.RED);
			primaryStage.setScene(GUI.startGame(player));
		});
	}
	
	private void makeInstances(Group g) {
		g.setId("pane");
		Text txt = new Text("Four in a row");
		txt.setFont(Font.font("Roboto", FontWeight.BOLD, 32));
		txt.setFill(Color.ALICEBLUE);
		txt.getStyleClass().add("txt");
		txt.setLayoutX(60);
		txt.setLayoutY(50);
		
		start = new Button("Human VS Human");
		start.setMinSize(300, 150);
		start.setLayoutX(50);
		start.setLayoutY(75);
		start.setFocusTraversable(false);


		startai = new Button("Human VS AI");
		startai.setMinSize(300, 150);
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
