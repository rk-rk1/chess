package Piece;

public class Bishop extends Piece{
    public Bishop(boolean iswhite, boolean ispiece) {
        super(iswhite, ispiece);
        if (iswhite){
            setRepresentation("bw ");
        }
        else {
            setRepresentation("bb ");
        }
    }


}
