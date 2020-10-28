public class Pond extends Piece {

    private boolean ismoved=false;
    public boolean getIsmoved(){
        return ismoved;
    }
    public void setIsmoved(){ // there is no way to revert back so it just a one time change
        ismoved = true;
    }

    public Pond(boolean iswhite, boolean inplay) {
        super(iswhite, inplay);
    }
    public int[][] moves() {
        int move[][] = new int[1][1];
        if (getIsmoved() == false) {
            move = new int[][]{{0, 1}, {0, 2}, {-1, 1}, {1, 1}};
        } else {
            move = new int[][] {{0, 1}, {-1, 1}, {1, 1}};
        }
        return move;
    }

}
