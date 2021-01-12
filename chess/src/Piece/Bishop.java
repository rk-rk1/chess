package Piece;

public class Bishop extends Piece {

    public Bishop(boolean iswhite, boolean ispiece) {
        super(iswhite, ispiece);
        if (iswhite) {
            setRepresentation("bw ");
        } else {
            setRepresentation("bb ");
        }
    }

    public Point[] moves() {
        Point[] move = new Point[28];
        for (int i = 1; i < 8; i++) {
            move[i - 1] = new Point(i, i, false, true, true);
            move[i + 7 - 1] = new Point(-i, -i, false, true, true);
            move[i + 14 - 1] = new Point(i, -i, false, true, true);
            move[i + 21 - 1] = new Point(-i, i, false, true, true);

        }
        return move;
    }
}
