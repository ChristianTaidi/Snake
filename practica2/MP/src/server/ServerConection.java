package practica2.MP.src.server;


import server.model.ScoreCounter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import practica2.MP.src.server.controller.SnakeController;

public class ServerConection {

    private int id=0;

    public void run(){
        try {

            ServerSocket socket = new ServerSocket(9305);
            ScoreCounter counter = new ScoreCounter();

            while (true){

                Socket s = socket.accept();

                new SnakeController( s , s.getInputStream(), s.getOutputStream(  ), this.id , counter).run();
                this.id += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
