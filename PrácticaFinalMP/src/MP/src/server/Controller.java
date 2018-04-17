package server;

import server.model.Snake;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

public class Controller implements Observer{

    private TreeMap<Integer,Runnable> execution;
    private int id=0;

    public Controller(){
        this.execution= new TreeMap<>();
    }

    public Controller(Socket s, InputStream inputStream, OutputStream outputStream) {

    }

    public void run(){
        try {

            ServerSocket socket = new ServerSocket(8000);

        while (true){


                socket.accept();
                id+=1;
                execution.put(id,new Snake()); //No necesario, el Server socket genera las hebras segun la peticion
                socket.accept();


        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
