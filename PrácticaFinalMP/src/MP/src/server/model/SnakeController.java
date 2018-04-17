package server.model;

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


    public SnakeController(Socket s, InputStream inputStream, OutputStream outputStream,int id, ScoreCounter scores) {

        this.s = s;
        this.iST = inputStream;
        this.oST = outputStream;
        this.snk = new Snake(scores,id);
        this.connected = true;

    }



    public void run() {

        while (this.connected) {
            try {

                BufferedReader read = new BufferedReader(new InputStreamReader(iST));
                String[] msg = read.readLine().split(";");
                if (msg[0].equals("FIN") ){
                    this.s.close();
                    this.connected = false;
                }else {
                    snk.send(msg);
                }
            } catch (IOException e) {
                try {
                    oST.write("ERR; Error al recibir mensaje mediante socket".getBytes());
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
