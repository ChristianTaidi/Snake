import GUI.SnakeGUI;
import server.ServerConnection;
import server.controller.SnakeController;

public class main {
    public static void main(String[]args){
        ServerConnection snkConn = new ServerConnection();
        snkConn.run();

    }
}
