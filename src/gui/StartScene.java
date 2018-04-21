package gui;

import inf101.v18.extras.Token;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import player.AI;

public class StartScene extends Scene {
	private Button start;
	private Button startai;

	public StartScene(Group g, double x, double y, Paint color, Stage primaryStage) {
		super(g, x, x, color);
		makeButtons(g);
		start.setOnAction(e -> primaryStage.setScene(GUI.startGame(null)));
		startai.setOnAction(e -> {
			AI<Token> player = new AI<>(Token.RED);
			primaryStage.setScene(GUI.startGame(player));
		});
	}
	
	private void makeButtons(Group g) {
		start = new Button("Human VS Human");
		start.setMinSize(300, 150);

		startai = new Button("Human VS AI");
		startai.setMinSize(300, 150);
		startai.setLayoutY(150);

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
