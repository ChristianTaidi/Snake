package server;

import server.controller.SnakeController;
import server.model.ScoreCounter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class ServerConnection {

    private int id;
    private Map<Integer,SnakeController> controllers;
    private ServerSocket socket;
    private ScoreCounter counter;

    public ServerConnection(){
        this.id=0;
        try {
            socket = new ServerSocket(9305);
        } catch (IOException e) {
            e.printStackTrace();
        }
        counter = new ScoreCounter();
    }

    public void run(){
        try{

            while (true){
                Socket s = socket.accept();

                this.controllers.put(this.id,new SnakeController( s , s.getInputStream(), s.getOutputStream(  ), this.id , counter));
                this.id += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
