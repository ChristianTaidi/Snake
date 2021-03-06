package server.model;

import server.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConection {

    private int id=0;

    public void run(){
        try {

            ServerSocket socket = new ServerSocket(8000);
            ScoreCounter counter = new ScoreCounter();
            while (true){

                Socket s = socket.accept();

                new SnakeController(s,s.getInputStream(),s.getOutputStream(),this.id,counter).run();
                this.id += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
