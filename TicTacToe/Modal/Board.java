public class Board{

    int size;
    PieceType [][]gameboard;
    Board(int size){
        this.size = size;
         gameboard = new PieceType[size][size];
    }
   public boolean addPiece(int row, int column, PieceType piecetype){
        if(gameboard[row][column]!=null){
           return false;
        }
        gameboard[row][column]=piecetype;
        return true;
   }
   
}