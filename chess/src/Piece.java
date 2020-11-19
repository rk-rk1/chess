public class Piece {
    private final boolean iswhite;
    private boolean inplay;
    private Position position;

    public boolean getIswhite(){
        return iswhite;
    }
    public boolean getInplay(){
        return inplay;
    }
    public Position getPosition(){
        return position;
    }

    public void setInplay(boolean inplay){
        this.inplay=inplay;
    }
    public void setPosition(Position position){
        this.position=position;
    }
    public boolean getIsmoved(){
        return false;
    }

    //constructors
    public Piece(boolean iswhite, boolean inplay, Position position){
        this.iswhite = iswhite;
        setInplay(inplay);
        setPosition(position);
    }
    public Piece(){
        this(false, false, new Position(0,0));
    }
    public Piece(Piece copy){
        this(copy.getIswhite(), copy.getInplay(), copy.getPosition());
    }


    public Point[] moves(){return null;}

}
