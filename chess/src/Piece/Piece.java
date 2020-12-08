package Piece;
public class Piece {
    private final boolean iswhite;
    private boolean ispiece, ismoved=false;
    private String representation;

    public boolean getIswhite(){ return iswhite; }
    public boolean getIspiece(){
        return ispiece;
    }
    public boolean getIsmoved(){ return ismoved; }
    public String getRepresentation(){return representation;}

    //change the methods to protected, so a piece can not be created?
    public void setIspiece(boolean ispiece){ this.ispiece = ispiece; }
    public void setIsmoved(){ // there is no way to revert back so it just a one time change
        this.ismoved = true;
    }
    protected void setRepresentation(String repesantation){
        this.representation =repesantation;
    }

    //constructors
    protected Piece(boolean iswhite, boolean ispiece){
        this.iswhite = iswhite;
        setIspiece(ispiece);
    }
    protected Piece(){
        this(false, false);
    }
    protected Piece(Piece copy){
        this(copy.getIswhite(), copy.getIspiece());
    }


    public Point[] moves(){return null;}

}
