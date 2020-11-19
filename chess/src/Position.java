public class Position {
    private int x, y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        if(x>=0) this.x = x;
    }
    public void setY(int y) {
        if(y>=0) this.y = y;
    }

    Position(int x, int y){
        setX(x);
        setY(y);
    }
    Position(){
        this(0,0);
    }
    Position(Position copy){
        this(copy.getX(),copy.getY());
    }



    public String toString(){
        return String.format("(%d, %d)",x,y);
    }
}
