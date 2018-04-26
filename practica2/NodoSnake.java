/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author k.lisowski
 */
public class NodoSnake {
   private int x;
   private int y;
    public NodoSnake(int x,int y){
        this.x=x;
        this.y=y;
        
}
    public void setX(int i){
        this.x= i;
    }
    public void setY(int i){
        this.y= i;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void incrementarX(){
        this.x+=1;
    }
    public void incrementarY(){
        this.y+=1;
    }
    public void swapNode(NodoSnake nodo){
    this.x= nodo.getX();
    this.y= nodo.getY();
}
}
