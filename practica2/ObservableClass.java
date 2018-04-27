/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author k.lisowski
 */
public class ObservableClass extends Observable implements KeyListener{
   
    private int id;
    public ObservableClass() {
        id =0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        String msg = "nothing";
        char i= e.getKeyChar();
        if(i == KeyEvent.VK_UP){
              msg= "up";
        }else if(i == KeyEvent.VK_DOWN){
              msg= "down";
        }else if(i == KeyEvent.VK_LEFT){
              msg= "left"; 
        }else if(i == KeyEvent.VK_RIGHT){
               msg= "right";
        }else if(i == KeyEvent.VK_V){
               msg= "speed";
        }
        notifyObservers(msg);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void botonPausaMouseClicked(java.awt.event.MouseEvent evt){

            notifyObservers("STOP");
    }
    
    public void botonInicioMouseClicked(java.awt.event.MouseEvent evt) {                                         
            Escaner scan = new Escaner();
            notifyObservers("STARTINFO;"+ scan.readPlayerName());
    }
}
