/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import practica2.Pixels;

/**
 *
 * @author k.lisowski
 */
public class Serpiente {
   private ArrayList<NodoSnake> lista;
   
    public Serpiente(){
    lista = new ArrayList<NodoSnake>();
    }
    public void setList(NodoSnake nodo){    
        lista.add(nodo);
    }
    public ArrayList<NodoSnake> getLista(){
       return this.lista;
    }
    
    public void actualizarLista(NodoSnake nodo){ 
        //Posiciones menos la cabeza
        
        for(int i = this.lista.size()-1; i > 0;i--){
            this.lista.get(i).swapNode(this.lista.get(i-1));
        }
        //actualizar la cabeza
            this.lista.get(0).swapNode(nodo);
    }
    public NodoSnake getTail(){
        return this.lista.get(this.lista.size()-1);
    }
    
}
