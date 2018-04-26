package practica2;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica2.ClientController;
import practica2.ClientSocket;
import practica2.MP.src.*;
import practica2.Pixels;
import server.ServerConection;
import server.ServerConection;


public class Main {
    public static void main(String[]args){
       Pixels pix= new Pixels();
        ClientController client =  new ClientController(pix);
    }
}
