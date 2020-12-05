package Piece;

public class Point {
    private final int x, y;
    private final boolean islinear, mayBeEnemy, mayBeEmty;

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
    public boolean getMayBeEmty(){
        return mayBeEmty;
    }

    public Point(int x, int y, boolean islinear, boolean mayBeEnemy, boolean mayBeEmty){
        //do a throw
        if(!mayBeEnemy && !mayBeEmty){
            throw new IllegalArgumentException("declared Point is not movable");
        }
        this.x=x;
        this.y=y;
        this.islinear=islinear;
        this.mayBeEnemy=mayBeEnemy;
        this.mayBeEmty=mayBeEmty;
        if(islinear && !(x==y || x==0 || y==0)){
            throw new IllegalArgumentException("declared point is not linear but is declared as such");

        }
    }
    public Point(){
        this(0,0,false,false,false);
    }
    public Point(Point copy){
        this(copy.getX(), copy.getY(), copy.getIslinear(), copy.getMayBeEnemy(), copy.getMayBeEmty());
    }

    public String toString(){
        return String.format("(%d, %d, Is linear %b, %b, %b", getX(), getY(), getIslinear(), getMayBeEnemy(), getMayBeEmty());
    }

}
