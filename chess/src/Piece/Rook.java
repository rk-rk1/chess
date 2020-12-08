package Piece;

public class Rook extends Piece{
    public Rook(boolean iswhite, boolean ispiece) {
        super(iswhite, ispiece);
        if (iswhite){
            setRepresentation("rw ");
        }
        else {
            setRepresentation("rb ");
        }
    }
    public Point[] moves() {
        Point[] move = new Point[28];
        for(int i = 1; i<8; i++){
            move[i-1]=new Point(i,0,false,true,true);
            move[i+7-1]=new Point(-i,0,false,true,true);
            move[i+14-1]=new Point(0,i,false,true,true);
            move[i+21-1]=new Point(0,-i,false,true,true);

        }
        return move;
    }

}
