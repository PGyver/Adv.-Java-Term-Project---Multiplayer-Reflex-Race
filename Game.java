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

/**
 * Created by Glynn on 4/18/2017.
 */
public class Game {
    String[] words = {"RED","BLUE","GREEN","PURPLE","YELLOW","ORANGE","PINK"};
    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.PURPLE, Color.YELLOW, Color.ORANGE, Color.PINK};
    boolean correct;

    public boolean isCorrect() {
        return correct;
    }

    public Text getNewWord(){
        int wordNum = (int)Math.random() * 8;
        int colorNum = (int)Math.random() * 8;
        Text word = new Text(words[wordNum]);
        word.setFill(colors[colorNum]);
        correct = wordNum == colorNum;
        return word;
    }
}
