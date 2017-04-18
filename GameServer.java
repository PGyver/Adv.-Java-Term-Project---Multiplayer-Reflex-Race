/**
 * Created by Glynn on 4/18/2017.
 */
import javafx.scene.text.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer {
    static int clientCount = 0;
    static ObjectOutputStream clients[] = new ObjectOutputStream[2];
    static Game game;
    static Text puzzleText;

    public static void main(String[] args) {
        try {
            System.out.println("Server Started...");
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Waiting...");
            while (true) {
                game = new Game();
                puzzleText = new Text();
                Timer timer = new Timer();
                timer.schedule(new GameTimer(game), 5000);
                Socket socket = serverSocket.accept();
                System.out.println("Client Accepted...");
                clients[clientCount] = new ObjectOutputStream(socket.getOutputStream());
                clientCount++;
                System.out.println("Start sending messages!");
                Runnable task = new HandleClient(socket);
                Thread thread = new Thread(task);
                thread.start();
                System.out.println("thread started...");


            }//end while
        } catch (Exception e) {
        }
    }//end main

    static class HandleClient implements Runnable {
        private Socket socket;
        ObjectInputStream fromClient;
        HandleClient(Socket socket) {
            this.socket = socket;
        }//constructor
        public void run() {
            try {
                fromClient = new ObjectInputStream(socket.getInputStream());
                while (true) {
                     int answer = fromClient.readInt();
                    Text win = new Text("You win");
                    Text lose = new Text("You lose");
                     if (game.isCorrect()){
                         for (int i = 0; i < clients.length; i++) {
                             if (clients[i] != null ) {
                                 clients[i].writeObject(win);
                             }
                         }
//                         //Someone wins
                    } else {
//                         //Someone loses
                     }

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }//run

    }//end static class

    static class GameTimer extends TimerTask {
        Game game;
        public GameTimer(Game game){
            this.game = game;
        }
        public void run() {
            try {
                puzzleText = game.getNewWord();
                for (int i = 0; i < clients.length; i++) {
                    if (clients[i] != null) {
                        clients[i].writeObject(puzzleText);
                    }
                }
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}


