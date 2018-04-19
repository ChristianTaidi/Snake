package server.model;

import java.util.Observable;
import java.util.TreeMap;

public class ScoreCounter extends Observable{

    private TreeMap<Integer,Integer> scores;

    public ScoreCounter(){
        this.scores= new TreeMap<>();
    }

    public void addClient(int id, int score){
        this.scores.put(id,score);
        notifyObservers();
    }

    public boolean deleteClient (int id){
        if (this.scores.containsKey(id)) {
            this.scores.remove(id);
            notifyObservers();
            return true;
        }else{
            return false;
        }
    }

    public boolean updateScore(int id,int score){
        if (this.scores.containsKey(id)) {
            this.scores.replace(id, score);
            notifyObservers();
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        String str= "PTS; " + String.valueOf(scores.size())+";";
        for(Integer i:this.scores.keySet()){
            str = str + i + ";" + this.scores.get(i) + ";" ;
        }
        return str;
    }

}
