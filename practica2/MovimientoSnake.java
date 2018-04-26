/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author k.lisowski
 */
public class MovimientoSnake extends JPanel implements ActionListener, KeyListener{
    private Timer time= new Timer(20,this);
    private int x =0, y =0, avanzarX =0, avanzarY=0;
    private Serpiente snake;
    
    public MovimientoSnake(Serpiente snake){
        time.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.snake= snake;
    }
    public void init(){
        
    }
    
    public void keyPressed(KeyEvent e){
        int b = e.getKeyCode();
        if(b == KeyEvent.VK_UP){
           avanzarX = 0;
           avanzarY = -1;
        }
        if(b == KeyEvent.VK_DOWN){
           avanzarX = 0;
           avanzarY = 1;
        }
        if(b == KeyEvent.VK_LEFT){
           avanzarX = -1;
           avanzarY = 0;
        }
        if(b == KeyEvent.VK_RIGHT){
           avanzarX = 1;
           avanzarY = 0;
        }
    }
    public void keyReleased(KeyEvent e){
  //code.
}
        public void keyTyped(KeyEvent e){
  //code.
}
    public void actionPerformed(ActionEvent e){
        
        if(x<0){
            avanzarX = 0;
            x=0;
        }
        if(x>370){
            avanzarX = 0;
            x=0;
        }
        if(y<0){
            avanzarY = 0;
            y=0;
        }
        if(x>480){
            avanzarX = 0;
            y=480;
        }
        //snake.actualizarLista();
        
        x = x +  avanzarX;
        y = y + avanzarY;
        repaint();
        
    }
}
