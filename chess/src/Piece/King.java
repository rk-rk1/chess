package Piece;

public class King extends Piece{
    
    public King(boolean iswhite, boolean ispiece) {
        super(iswhite, ispiece);
        if (iswhite){
            setRepresentation("kw ");
        } else {
            setRepresentation("kb ");
        }
    }

    public Point[] moves() {
        Point[] move = new Point[8];
        move[0]=new Point(0,1,false,true,true);
        move[1]=new Point(0,-1,false,true,true);
        move[2]=new Point(1,0, false,true,true);
        move[3]=new Point(-1,0,false,true,true);
        move[4]=new Point(1,1,false,true,true);
        move[5]=new Point(-1,-1,false,true,true);
        move[6]=new Point(-1,1,false,true,true);
        move[7]=new Point(1,-1,false,true,true);

        return move;
    }
}
