
import Piece.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class chess {

    private final int rows = 8, columns = 8;// board size

    private boolean endgame = false;

    public Piece getPiece(Piece[][] board, Position place) {
        return board[place.getY()][place.getX()];
    }

    public void setPiece(Piece[][] board, Position place, Piece changeTo) {
        board[place.getY()][place.getX()] = changeTo;
    }

    /*
     returns (-2, -2) if invalid arguments are inserted;
     returns (-1, -1) if the user wants to end the game;
     returns integer positive numbers smaller than rows/columns,
     if the user is entered valid information to continue;
     */
    private Position insertXYCall() {
        Position ret;
        try {
            ret = insertXY();// can be from (-1, -1) to (rows,columns)
        } catch (InputMismatchException ime) {
            System.out.println("coordinates of x and y must be integers");
            ret = new Position(-2, -2); //Position(-2,-2) gives the caller method the info that the insert is not successful
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            ret = new Position(-2, -2); //same as the upper comment
        }
        return ret;
    }

    private Position insertXY() {
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        if (x == -1 && y == -1) {
            return new Position(-1, -1); //enter -1 -1 to end/surrender/save
        }
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x and y must not be negative");
        }
        if (x >= rows || y >= columns) {
            throw new IllegalArgumentException("x and y must be less than the number of rows and columns");
        }
        return new Position(x, y);
    }

    public void turn(Piece[][] a, boolean WhitesTurn) {
        if (WhitesTurn) {
            System.out.println("it's white's turn");
        } else {
            System.out.println("it's black's turn");
        }
        Position PiecePosition = new Position(-2, -2);
        while (PiecePosition.equals(new Position(-2, -2))) {
            System.out.println("enter the position of the place you like to move \nif you want to end the game enter -1 -1");//or surrender
            PiecePosition = insertXYCall();
            if (PiecePosition.equals(new Position(-1, -1))) {
                endgame = true;
                return;
            }
            if (PiecePosition.equals(new Position(-2, -2))) {
                continue;
            }

            if (!getPiece(a, PiecePosition).getIspiece()) {
                PiecePosition = new Position(-2, -2);
                continue;
            }
            if (getPiece(a, PiecePosition).getIswhite() == !WhitesTurn) {
                PiecePosition = new Position(-2, -2);
                continue;
            }
            System.out.println(PiecePosition);
            Piece selected = getPiece(a, PiecePosition);

            Position MoveToP = new Position(-2, -2);
            while (MoveToP.equals(new Position(-2, -2))) {
                System.out.println("enter the position of where you want to move to \nif you want to choose another pond enter -1 -1");
                MoveToP = insertXYCall();
                if (MoveToP.equals(new Position(-2, -2))) {
                    continue;
                }
                if (MoveToP.equals(new Position(-1, -1))) {
                    PiecePosition = new Position(-2, -2);
                    break;
                }
                boolean unsuccessful = true;
                Movecheck:
                for (int i = 0; i < getPiece(a, PiecePosition).moves().length; i++) {
                    if (PiecePosition.getX() + selected.moves()[i].getX() < 0 || PiecePosition.getY() + selected.moves()[i].getY() < 0
                            || PiecePosition.getY() + selected.moves()[i].getY() > columns - 1 || PiecePosition.getX() + selected.moves()[i].getX() > rows - 1) {
                        continue;
                    }
                    Position sum = new Position(PiecePosition.sumPoint(selected.moves()[i]));
                    System.out.println(sum);// remove after doing it

                    if (sum.equals(MoveToP)) {
                        
                        if (!selected.moves()[i].getIslinear()) {
                            
                            if ((selected.moves()[i].getMayBeEmpty() && !getPiece(a, MoveToP).getIspiece())
                                    || (selected.moves()[i].getMayBeEnemy() && getPiece(a, MoveToP).getIswhite() == !WhitesTurn && getPiece(a, MoveToP).getIspiece())) {
                                setPiece(a, MoveToP, selected);
                                setPiece(a, PiecePosition, new Emtyspace());
                                unsuccessful = false;
                                break;
                            }
                        } else {
                            //if (selected.moves()[i].getX()<0){
                            //  if(selected.moves())
                            Point change = new Point(200, 200, true, true, true);

                            Point pos = new Point(MoveToP.getX() - PiecePosition.getX(), MoveToP.getY() - PiecePosition.getY(), true, true, true);
                            if (pos.getX() == 0) {
                                if (pos.getY() == 0) {
                                    MoveToP = new Position(-2, -2);
                                    continue;
                                } else if (pos.getY() > 0) {
                                    change = new Point(0, 1, true, true, true);
                                } else if (pos.getY() < 0) {
                                    change = new Point(0, -1, true, true, true);
                                }
                            } else if (pos.getX() > 0) {
                                if (pos.getY() == 0) {
                                    change = new Point(1, 0, true, true, true);
                                } else if (pos.getY() > 0) {
                                    change = new Point(1, 1, true, true, true);

                                } else if (pos.getY() < 0) {
                                    change = new Point(1, -1, true, true, true);

                                }
                            } else if (pos.getX() < 0) {
                                if (pos.getY() == 0) {
                                    change = new Point(-1, 0, true, true, true);

                                } else if (pos.getY() > 0) {
                                    change = new Point(-1, 1, true, true, true);
                                } else if (pos.getY() < 0) {
                                    change = new Point(-1, -1, true, true, true);
                                }
                            }
                            
                            for (Position j = new Position(PiecePosition.sumPoint(change)); !j.equals(MoveToP); j = j.sumPoint(change)) {
                                System.out.println("change " + j);
                                if (getPiece(a, j).getIspiece()) {
                                    MoveToP = new Position(-2, -2);
                                    System.out.println("text");
                                    break Movecheck;
                                }
                            }
                            if ((selected.moves()[i].getMayBeEmpty() && !getPiece(a, MoveToP).getIspiece())
                                    || (selected.moves()[i].getMayBeEnemy() && getPiece(a, MoveToP).getIswhite() == !WhitesTurn && getPiece(a, MoveToP).getIspiece())) {
                                
                                
                                setPiece(a, MoveToP, selected);
                                setPiece(a, PiecePosition, new Emtyspace());
                                unsuccessful = false;
                                break;
                            }
                        }
                        // if it is available to move but for some reason can't, this is to end the cycle, currently 19 lines above
                        MoveToP = new Position(-2, -2);
                        System.out.println("invalid input please input again");
                        break;
                    }
                }
                if (unsuccessful) {
                    MoveToP = new Position(-2, -2);
                    System.out.println("invalid input please input again");
                }
            }
        }
    }

    public void printBoard(Piece[][] b) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(b[i][j].getRepresentation());
            }
            System.out.println();
        }
    }

    public void winCondition(Piece[][] b) {
        boolean whiteKingAlive = false;
        boolean blackKingAlive = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (b[i][j].getRepresentation().equals("kw ")) {
                    whiteKingAlive = true;
                }
                if (b[i][j].getRepresentation().equals("kb ")) {
                    blackKingAlive = true;
                }
            }
        }
        if (!whiteKingAlive) {
            System.out.println("black wins.");
            endgame = true;
            return;
        }
        if (!blackKingAlive) {
            System.out.println("white wins.");
            endgame = true;
            return;

        }
    }

    public static void main(String[] args) {
        chess obj = new chess();
        Piece[][] board = new Piece[obj.columns][obj.rows];
        for (int i = 0; i < obj.columns; i++) {
            for (int j = 0; j < obj.rows; j++) {
                board[i][j] = new Emtyspace();
            }
        }
        //inserts the ponds and knights and kings; white is top, black is bottom;
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Pond(true, true);
            board[6][i] = new Pond(false, true);
        }
        board[0][1] = new Knight(true, true);
        board[0][6] = new Knight(true, true);
        board[7][1] = new Knight(false, true);
        board[7][6] = new Knight(false, true);

        board[0][3] = new King(true, true);
        board[7][3] = new King(false, true);

        board[0][0] = new Rook(true, true);
        board[0][7] = new Rook(true, true);
        board[7][0] = new Rook(false, true);
        board[7][7] = new Rook(false, true);

        board[0][2] = new Bishop(true, true);
        board[0][5] = new Bishop(true, true);
        board[7][2] = new Bishop(false, true);
        board[7][5] = new Bishop(false, true);

        board[0][4] = new Queen(true, true);
        board[7][4] = new Queen(false, true);
        // main game cycle
        boolean isWhiteTurn = true;
        obj.printBoard(board);
        while (true) {
            
            obj.turn(board, isWhiteTurn);
            obj.printBoard(board);
            obj.winCondition(board);
            if (obj.endgame) {
                return;
            }
            isWhiteTurn = !isWhiteTurn;
        }

    }
}
