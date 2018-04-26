/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica2.*;
/**
 *
 * @author k.lisowski
 */
public class ClientController {
    private Pixels pixelController;
    private ClientSocket socket;
    
    public ClientController(Pixels pixelController){
        this.pixelController= pixelController;
        try {
            this.socket = new ClientSocket();
        } catch (Exception ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.pixelController.setVisible(true);
    }
    
    public NodoSnake parseadorMov(String cadena){
        NodoSnake nodo= new NodoSnake(0,0);
        String[] partes= cadena.split(";");
        if(partes[0].equals("MOV")){
                nodo.setX(Integer.parseInt(partes[2]));
                nodo.setY(Integer.parseInt(partes[3]));
        }
        return nodo;
    }
    
    public String crearMensaje(KeyEvent e){
        String msg = "nothing";
        if(e.getKeyChar() == KeyEvent.VK_UP){
              msg= "up";
        }else if(e.getKeyChar() == KeyEvent.VK_DOWN){
              msg= "down";
        }else if(e.getKeyChar() == KeyEvent.VK_LEFT){
              msg= "left"; 
        }else if(e.getKeyChar() == KeyEvent.VK_RIGHT){
               msg= "right";
        }else if(e.getKeyChar() == KeyEvent.VK_V){
               msg= "speed";
        }
        return msg;
    }
    
    public void parseadorMensajesServer(String msg){
        String[] partes= msg.split(";");
        if(partes[0].equals("POS")){
            this.pixelController.draw(devolverNodo(partes[2], partes[3]));
            this.pixelController.unDraw(devolverNodo(partes[4], partes[5]));
        }else if(partes[0].equals("SCR")){
            
        }else if(partes[0].equals("TRS")){
            this.pixelController.draw2(devolverNodo(partes[1], partes[2]));
        }
    }
    public NodoSnake devolverNodo(String s1, String s2){
        NodoSnake nodo= new NodoSnake(Integer.parseInt(s1),Integer.parseInt(s2));
        return nodo;
    }
}
