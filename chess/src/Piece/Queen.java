package Piece;

public class Queen extends Piece {

    public Queen(boolean iswhite, boolean ispiece) {
        super(iswhite, ispiece);
        if (iswhite) {
            setRepresentation("qw ");
        } else {
            setRepresentation("qb ");
        }
    }

    public Point[] moves() {
        Point[] move = new Point[56];
        for (int i = 1; i < 8; i++) {
            move[i - 1] = new Point(0, i, true, true, true);
            move[i - 1 + 7] = new Point(0, -i, true, true, true);
            move[i - 1 + 14] = new Point(i, 0, true, true, true);
            move[i - 1 + 21] = new Point(-i, 0, true, true, true);
            move[i - 1 + 28] = new Point(i, i, true, true, true);
            move[i - 1 + 35] = new Point(-i, -i, true, true, true);
            move[i - 1 + 42] = new Point(-i, i, true, true, true);
            move[i - 1 + 49] = new Point(i, -i, true, true, true);
        }
        return move;
    }
}
