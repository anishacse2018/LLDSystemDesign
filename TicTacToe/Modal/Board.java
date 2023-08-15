import java.util.*;
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

   public ArrayList<Pair> getEmptyCells(){
      ArrayList<Pair> a = new ArrayList<>();
      for(int i=0;i<size;i++){
         for(int j=0;j<size;j++){
            if(gameboard[i][j]==null){
             Pair p = new Pair(i,j);
              a.add(p);
            }
         }
      }
      return a;
   }
 
   public void printBoard(){
      for(int i=0;i<size;i++){
         for(int j=0;j<size;j++){
            if(gameboard[i][j]!=null){
                  System.out.print(gameboard[i][j]+" ");
            }else{
               System.out.print(" ");
            }
            System.out.print("| ");
         }
         System.out.println();
      }
   }
   
}
class Pair{
   int row;
   int column;
   Pair(int row, int column){
     this.row = row;
     this.column = column;
   }
}