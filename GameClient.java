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
import javafx.beans.property.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class GameClient extends Application{
    String userName = "";
    ObjectOutputStream toServer;
    Text word;
    public void start(Stage primaryStage){
        Pane gamePane = new Pane();
        BorderPane frame = new BorderPane();
        BorderPane answerFrame = new BorderPane();
        word = new Text(140,180,"Waiting for next round");

        Button correctButton = new Button("Correct");
        correctButton.setMinSize(400,75);
        Text hintField = new Text(50,50,"You suck");


        gamePane.getChildren().add(word);
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
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Waiting...");
            System.out.println("Server Accepted...");
            System.out.println("Let the games begin!");
            Runnable task = new HandleClient(socket, word);
            Thread thread = new Thread(task);
            thread.start();
            toServer = new ObjectOutputStream(socket.getOutputStream());
        }catch(Exception e){}

        correctButton.setOnMouseClicked(e -> {
            try {
                toServer.writeInt(1);
            }catch (Exception e2){}
        });
    }
    public static void main(String[] args){
        launch(args);
    }

}//end class
class HandleClient implements Runnable{
    private Socket socket;
    Text word;

    HandleClient(Socket socket, Text word){
        this.socket = socket;
        this.word = word;
    }//constructor

    public void run(){
        try{
            ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());
            while(true){
                word = (Text)fromClient.readObject();
            }//while
        }catch(Exception e){
            System.out.println(e);
        }
    }//run
}//class

