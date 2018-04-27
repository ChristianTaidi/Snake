package practica2;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica2.ClientController;
import practica2.ClientSocket;
import practica2.Pixels;



public class Main {
    public static void main(String[]args){
        ObservableClass observable = new ObservableClass();
        Pixels pix= new Pixels(observable);
        ClientController client =  new ClientController(pix);
    }
}
