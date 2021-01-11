
import Piece.Point;

public class Position {

    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //make trow statements
    public void setX(int x) {
        if (x < -2) {
            throw new IllegalArgumentException("x must be larger");
        } else {
            this.x = x;
        }
    }

    public void setY(int y) {
        if (y < -2) {
            throw new IllegalArgumentException("y must be larger");
        } else {
            this.y = y;
        }
    }

    Position(int x, int y) {
        setX(x);
        setY(y);
    }

    Position() {
        this(0, 0);
    }

    Position(Position copy) {
        this(copy.getX(), copy.getY());
    }

    public boolean equals(Position b) {
        //self check
        if (this == b) {
            return true;
        }
        // null check
        if (b == null) {
            return false;
        }
        return this.getX() == b.getX() && this.getY() == b.getY();
    }

    public Position sumPoint(Point add) {
        return new Position(this.getX() + add.getX(), this.getY() + add.getY());
    }

    public Position minPoint(Position add) {
        return new Position(this.getX() - add.getX(), this.getY() - add.getY());
    }

    public Position sumPosition(Position uno) {
        return new Position(this.getX() + uno.getX(), this.getY() + uno.getY());
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
