package Piece;

public class Knight extends Piece{

    public Knight(boolean iswhite, boolean ispiece) {
        super(iswhite, ispiece);
        if (iswhite){
            setRepresentation("nw ");
        }
        else {
            setRepresentation("nb ");
        }
    }

    public Point[] moves() {
        Point[] move = new Point[8];
        move[0] = new Point(-2,-1,false,true,true);
        move[1] = new Point(-2,1,false,true,true);
        move[2] = new Point(-1,-2,false,true,true);
        move[3] = new Point(-1,2,false,true,true);
        move[4] = new Point(2,-1,false,true,true);
        move[5] = new Point(2,1,false,true,true);
        move[6] = new Point(1,-2,false,true,true);
        move[7] = new Point(1,2,false,true,true);

        return move;
    }
}
