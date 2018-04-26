
package practica2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author k.lisowski
 */
public class Movimiento extends JPanel implements ActionListener, KeyListener{
    
    Timer time= new Timer(20,this);
    int x =0, y =0, avanzarX =0, avanzarY=0;
    
    public Movimiento(){
        time.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    public void init(){
        
    }
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.setColor(Color.GREEN);
       g.fillRect(x, y, 30, 30);
       
       
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
        
        x = x +  avanzarX;
        y = y + avanzarY;
        repaint();
        
    }
    public static void main(String[] args){
        Movimiento mov = new Movimiento();
        JFrame jf = new JFrame();
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(mov);
        
    }
}
