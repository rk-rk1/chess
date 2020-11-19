public class Pond extends Piece {

    private boolean ismoved=true;

    public boolean getIsmoved(){
        return ismoved;
    }
    public void setIsmoved(){ // there is no way to revert back so it just a one time change
        ismoved = true;
    }

    public Pond(boolean iswhite, boolean inplay, Position place) {
        super(iswhite, inplay, place);
    }

    public Point[] moves() {
        Point[] move;
        if(this.getIswhite()) {
            if (!getIsmoved()) {
                move = new Point[4];//{{0, -1}, {0, -2}, {-1, -1}, {1, -1}};
                move[0] = new Point(0, -1, false, false, true);
                move[1] = new Point(0, -2, true, false, true);
                move[2] = new Point(-1, -1, false, true, false);
                move[3] = new Point(1, -1, false, true, false);
            } else {
                move = new Point[3];//{{0, -1}, {-1, -1}, {1, -1}};
                move[0] = new Point(0, -1, false, false, true);
                move[1] = new Point(-1, -1, false, true, false);
                move[2] = new Point(1, -1, false, true, false);
            }
        }
        else {
            if (!getIsmoved()) {
                move = new Point[4];//{{0, 1}, {0, 2}, {-1, 1}, {1, 1}};
                move[0] = new Point(0, 1, false, false, true);
                move[1] = new Point(0, 2, true, false, true);
                move[2] = new Point(-1, 1, false, true, false);
                move[3] = new Point(1, 1, false, true, false);
            } else {
                move = new Point[3];//{{0, 1}, {-1, 1}, {1, 1}};
                move[0] = new Point(0, 1, false, false, true);
                move[1] = new Point(-1, 1, false, true, false);
                move[2] = new Point(1, 1, false, true, false);
            }
        }
        return move;
    }
    public String toString(){
        return String.format("(%d, %d)", getPosition().getX(), getPosition().getY());
    }
}
