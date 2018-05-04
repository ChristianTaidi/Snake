package sockettest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSock {

    public synchronized void run() {
        ServerSocket socket;
        try {
            socket = new ServerSocket(8000);
            while(true) {

                Socket s = socket.accept();
                System.out.println(new BufferedReader(new InputStreamReader(s.getInputStream())).readLine());

                new PrintWriter(s.getOutputStream(),true).write("OK");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

