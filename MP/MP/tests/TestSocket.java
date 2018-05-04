import sockettest.ServerSock;

import java.io.*;
import java.net.Socket;

public class TestSocket {

    public static void main(String []args){


        try {
            Socket socket = new Socket("127.0.0.1" ,8000);
            try {

                new PrintWriter(socket.getOutputStream(),true).write("Connect");

                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));


                System.out.println(bf.readLine());
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
