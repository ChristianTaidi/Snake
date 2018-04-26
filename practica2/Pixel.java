/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author k.lisowski
 */
public class Pixel {
    JPanel[][] panels;
    public Pixel(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(90, 90, 0, 0));
        panels = new JPanel[90][90];
        for(int i=0; i< 90;i++){
            for(int j=0;j<90;j++){
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.red);
                frame.add(panels[i][j]);
    }
        }
    }
    
    public static void main(String args[]) {
        Pixel px= new Pixel();
    }
}
