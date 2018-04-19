package server.controller;

import exceptons.IllegalMessageArgument;
import server.model.ScoreCounter;
import server.model.Snake;

import java.io.*;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class SnakeController extends Thread implements Observer {

    private Socket s;
    private InputStream iST;
    private OutputStream oST;
    private Snake snk;
    private boolean connected;
    BufferedReader read;
    private boolean stopped;


    public SnakeController(Socket s, InputStream inputStream, OutputStream outputStream,int id, ScoreCounter scores) {

        this.s = s;
        this.iST = inputStream;
        this.oST = outputStream;
        this.snk = new Snake(scores,id);
        this.read = new BufferedReader(new InputStreamReader(iST));
        this.connected = true;
        this.stopped = true;

    }



    public void run() {

        while(stopped){
            try {
                String[] start = read.readLine().split(";");
                if (start[0].equals("STARTINFO")){
                    this.snk.setName(start[1]);
                    this.stopped = false;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        while (this.connected) {
            try {


                String[] msg = read.readLine().split(";");
                if (msg[0].equals("FIN") ){
                    this.s.close();
                    this.connected = false;
                }else {
                    switch (msg[0]){
                        case "DIR":
                            this.snk.setMov(msg[1]);

                            break;
                        case "SCR":

                            this.snk.addScore();
                            break;
                            
                        case "STP":

                            this.stopped=true;
                            break;

                        case "START":

                                this.stopped = false;
                                break;


                        default :
                            throw new IllegalMessageArgument("Internal connection error, disconnecting");
                    }

                    snk.move();
                }


            } catch (IOException e) {
                try {
                    oST.write("ERR; Error al recibir mensaje mediante socket".getBytes());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IllegalMessageArgument e) {
                try {
                    oST.write(( "ERR; " + e.getMessage()).getBytes());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }



    @Override
    public void update(Observable o, Object arg) {
        String msg = o.toString();

        try {

            oST.write(msg.getBytes());

        } catch (IOException e) {
            try {
                oST.write("ERR; Error al enviar mensaje mediante socket".getBytes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
