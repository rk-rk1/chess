package Piece;

import static java.lang.Math.abs;


public class Point {
    private final int x, y;
    private final boolean islinear, mayBeEnemy, mayBeEmpty;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean getIslinear(){
        return islinear;
    }
    public boolean getMayBeEnemy(){
        return mayBeEnemy;
    }
    public boolean getMayBeEmpty(){
        return mayBeEmpty;
    }

    public Point(int x, int y, boolean islinear, boolean mayBeEnemy, boolean mayBeEmpty){
        //do a throw
        if(!mayBeEnemy && !mayBeEmpty){
            throw new IllegalArgumentException("declared Point is not movable");
        }
        this.x=x;
        this.y=y;
        this.islinear=islinear;
        this.mayBeEnemy=mayBeEnemy;
        this.mayBeEmpty = mayBeEmpty;
        if(islinear && !(abs(x)==abs(y) || x==0 || y==0)){
            throw new IllegalArgumentException("declared point is not linear but is declared as such");

        }
    }
    public Point(){ this(0,0,false,false,false);
    }
    public Point(Point copy){
        this(copy.getX(), copy.getY(), copy.getIslinear(), copy.getMayBeEnemy(), copy.getMayBeEmpty());
    }

    public String toString(){
        return String.format("(%d, %d, Is linear %b, %b, %b", getX(), getY(), getIslinear(), getMayBeEnemy(), getMayBeEmpty());
    }

}
