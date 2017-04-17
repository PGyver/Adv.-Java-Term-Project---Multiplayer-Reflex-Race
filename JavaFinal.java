//glynn leininger, Final Project
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.scene.input.*;
import javafx.scene.control.*;

public class JavaFinal extends Application{
	public void start(Stage primaryStage){
		Pane gamePane = new Pane();
		BorderPane frame = new BorderPane();
		Rectangle correctButton = new Rectangle(0,0,400,50);
		correctButton.setFill(Color.BLUE);
		Text hintField = new Text(50,50,"You suck");


		gamePane.getChildren().add(hintField);
		frame.setCenter(gamePane);
		frame.setBottom(correctButton);
		//correctButton.setAlignment(Pos.BOTTOM_CENTER);

		Scene scene = new Scene(frame, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("");
		primaryStage.show();
	}
	public static void main(String[] args){
		launch(args);
	}

}