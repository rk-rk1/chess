package Piece;
public class Piece {
    private final boolean iswhite;
    private boolean ispiece, ismoved=false;
    private String repesantation;

    public boolean getIswhite(){
        return iswhite;
    }
    public boolean getIspiece(){
        return ispiece;
    }
    public boolean getIsmoved(){ return ismoved; }
    public String getRepesantation(){return repesantation;}

    //change the methods to protected, so a piece can not be created?
    public void setIspiece(boolean ispiece){ this.ispiece = ispiece; }
    public void setIsmoved(){ // there is no way to revert back so it just a one time change
        this.ismoved = true;
    }
    protected void setRepesantation(String repesantation){
        this.repesantation=repesantation;
    }

    //constructors
    public Piece(boolean iswhite, boolean ispiece){
        this.iswhite = iswhite;
        setIspiece(ispiece);
    }

    public Piece(){
        this(false, false);
    }
    public Piece(Piece copy){
        this(copy.getIswhite(), copy.getIspiece());
    }


    public Point[] moves(){return null;}

}
