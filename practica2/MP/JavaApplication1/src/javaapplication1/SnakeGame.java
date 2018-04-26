/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author c.taidi.2016 */
public class SnakeGame {
    
    private int xCoord;
    private int yCoord;
    private int speed;
    private int lifes;
    private String userName;
    
    public SnakeGame(String name, int lifes){
        this.userName = name;
        this.lifes = lifes;
        
    }
    
    public SnakeGame(String name, int lifes,int speed){
        this.userName = name;
        this.lifes = lifes;
        this.speed = speed;
    }
    
}
