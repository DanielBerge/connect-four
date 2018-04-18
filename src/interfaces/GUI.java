package interfaces;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	      Text text = new Text();      
	
	      text.setText("Four in a row"); 
	      text.setX(50); 
	      text.setY(50); 
	      
	      Circle circle = new Circle();
	      
		
		Group root = new Group(text);
		
		Scene scene = new Scene(root, 600, 300, Color.BLUE);
		primaryStage.setTitle("Four in a row");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String args[]){   
		   launch(args);      
		}  
	
}
