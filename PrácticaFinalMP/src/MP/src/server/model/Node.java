package server.model;

public class Node {

    private int x;
    private int y;

    public Node(int x, int y){

        this.x=x;
        this.y=y;

    }

    public void swapNode(Node n){
        this.x=n.getX();
        this.y=n.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void increaseX() {
        this.x+=1;
    }

    public void decreaseX() {
        this.x-=1;
    }

    public void decreaseY() {
        this.y-=1;
    }

    public void increaseY() {
        this.y +=1;
    }
}
