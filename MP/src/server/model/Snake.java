package server.model;



import exceptons.IllegalMessageArgument;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class Snake extends Observable {

    private int id;
    private int score;
    private String mov;
    private Node head;
    private int length;
    private Node tail;
    private ScoreCounter scores;

    private Set<Node> body;

    public Snake(ScoreCounter counter,int id){
        this.head = new Node(45,45);
        this.body = new HashSet<>();
        this.body.add(head);
        this.tail=head;
        this.id = id;
        this.scores = counter;
    }

    public void move(){

        switch (this.mov){
            case "UP":
                    this.head.increaseX();
                break;
            case "DWN":
                    this.head.decreaseX();
                break;
            case "LFT":
                    this.head.decreaseY();
                break;
            case "RGT":
                    this.head.increaseY();
                break;
        }
        notifyObservers();
    }

    public void addScore(){
        this.score += 100;
        this.scores.updateScore(this.id,this.score);
        this.length += 1;
    }

    public void setMov(String mov){
        this.mov = mov;

    }

    public int getX() {
        return this.head.getX();
    }


    public int getY() {
        return this.head.getY();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        score = score;
    }

    @Override
    public String toString(){
        return "MOV; " + this.id + this.getX() + ";" + this.getY() + ";" + this.tail.getX() + ";" + this.tail.getY();
    }

    public void send(String[] msg) throws IllegalMessageArgument{

        switch (msg[0]){
            case "DIR":
                this.mov = msg[1];
                this.move();
                break;
            case "SCR":
                this.addScore();
                this.scores.updateScore(this.id,this.score);
                notifyObservers();
                break;


            default :

                throw new IllegalMessageArgument("Internal connection error, disconnecting");


        }
    }
}
