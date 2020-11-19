import java.util.Random;
import java.util.Scanner;

public class chess {
    private int rows=8, colums=8;// board size

    public boolean inplayspace(int a, int b){
        if(a>rows||a<0||b>colums||b<0) return false;
        return true;
    }

    public Position checkPosition(Position p, Point move){
        return new Position(p.getX()+move.getX(), p.getY()+ move.getY());
    }

    public void turn(Piece[] a, boolean WhitesTurn){
        int x, y;
        Piece selected;
        outer_loop:
        while(true){
            x = new Scanner(System.in).nextInt();//make try cach block
            y = new Scanner(System.in).nextInt();
            if (inplayspace(x, y)){
                for(int i=0; i<a.length; i++){
                    if(inplayspace(x, y))
                    if(a[i].getPosition().getX()==x && a[i].getPosition().getY()==y && a[i].getIswhite()==WhitesTurn){
                        selected=a[i];
                        break outer_loop;
                    }
                }
            }
        }
        System.out.println("piece"+ selected.getPosition());
        Point[] availableMoves = selected.moves();
        for(int i=0; i<availableMoves.length; i++){
            if(availableMoves[i].getIslinear()){

            }
            else {

            }
        }
    }

    public void printBoard(char b[][]){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        //inatilisations of the pice set and the char represantation
        chess obj = new chess();
        char[][] board = new char [obj.rows][obj.colums];
        for (int i=0; i<board.length; i++){
            board[i]= new char[]{'*', '*', '*', '*', '*', '*', '*', '*'};
        }
        Piece[] sample = new Piece[16];


        //incertes the ponds; white is top, black is bottom
        for(int i=0; i<sample.length; i++){
            if (i<8) {
                sample[i]= new Pond(true, true, new Position(i, 1));
            }
            else{
                sample[i]= new Pond(true, true, new Position(i-8, 6));
            }
            System.out.println(sample[i]);
        }

        //changing the char array to mach with the positions of the ponds
        for(int i=0; i<sample.length; i++){
            board[sample[i].getPosition().getY()][sample[i].getPosition().getX()] = 'p';
        }

        obj.printBoard(board);
        obj.turn(sample, true);
    }


}
