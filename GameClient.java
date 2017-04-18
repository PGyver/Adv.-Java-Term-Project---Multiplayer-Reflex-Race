/**
 * Created by Glynn on 4/18/2017.
 */
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

import java.io.*;
import java.net.*;
import java.util.*;

public class GameClient extends Application{
    String userName = "";
    ObjectOutputStream toServer;
    public void start(Stage primaryStage){
        Pane gamePane = new Pane();
        BorderPane frame = new BorderPane();
        BorderPane answerFrame = new BorderPane();

        //Rectangle correctButton = new Rectangle(400,75);
        Button correctButton = new Button("Correct");
        correctButton.setMinSize(400,75);
        //correctButton.setFill(Color.BLUE);
        Text hintField = new Text(50,50,"You suck");


        gamePane.getChildren().add(hintField);
        answerFrame.setBottom(correctButton);
        answerFrame.setTop(hintField);
        answerFrame.setAlignment(hintField,Pos.BOTTOM_CENTER);

        frame.setCenter(gamePane);
        frame.setBottom(answerFrame);

        Scene scene = new Scene(frame, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.show();

        try{
            System.out.println("Client Started...");
            Socket socket = new Socket("localHost", 8000);
            System.out.println("Waiting...");
            System.out.println("Server Accepted...");
            System.out.println("Start sending messages!");
            Runnable task = new HandleClient(socket);
            Thread thread = new Thread(task);
            thread.start();
            toServer = new ObjectOutputStream(socket.getOutputStream());
        }catch(Exception e){}
    }
    public static void main(String[] args){
        launch(args);
    }

}//end class
class HandleClient implements Runnable{
    private Socket socket;

    HandleClient(Socket socket){
        this.socket = socket;
    }//constructor

    public void run(){
        try{
            ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
            while(true){
                //String message = (String)fromClient.readObject();





            }//while
        }catch(Exception e){
            System.out.println(e);
        }
    }//run
}//class

