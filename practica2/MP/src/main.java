import GUI.SnakeGUI;
import server.ServerConection;

public class main {
    public static void main(String[]args){
        ServerConection server = new ServerConection();
        server.run();
    }
}
