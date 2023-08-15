import java.util.*;
public class TicTacToeGame{
 
    Deque<Player>players;
    Board gameboard;

    public void initializeGame(){
       players = new LinkedList<Player>();
       Player player1 = new Player("player1",PieceType.X);
       Player player2 = new Player("player2",PieceType.O);
       players.add(player1);
       players.add(player2);
       gameboard = new Board(3);
    }
    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player p1 = players.removeFirst();
            gameboard.printBoard();
            ArrayList<Pair> freeSpaces = gameboard.getEmptyCells();
            if(freeSpaces.isEmpty()){
               noWinner = false;
               continue;
            }
            System.out.println("Please enter row and column values: ");
            Scanner sc = new Scanner(System.in);
            int inputRow = sc.nextInt();
            int inputCol = sc.nextInt(); 
           // sc.close();
            boolean success = gameboard.addPiece(inputRow, inputCol, p1.getPieceType());
            if(!success){
                 System.out.println("Invalid values, try again");
                 players.addFirst(p1);
                 continue;
            }
            players.addLast(p1);
            boolean winner = isThereWinner(inputRow,inputCol,p1.getPieceType());
            if(winner){
                return p1.getName();
            }
        }
        return "tie";
    }
   public boolean isThereWinner(int row,int column,PieceType piecetype){
        boolean rowMatch =true;
        boolean columnMatch = true;
        boolean upperdiagonalMatch = true;
        boolean lowerdiagonalMatch=true;
        for(int i=0;i<3;i++){
            if(gameboard.gameboard[row][i]==null || gameboard.gameboard[row][i]!=piecetype){
                 rowMatch = false;
            }
        }
        for(int i=0;i<3;i++){
            if(gameboard.gameboard[i][column]==null || gameboard.gameboard[i][column]!=piecetype){
                 columnMatch = false;
            }
        }
        for(int i=0,j=0;i<3;i++,j++){
            if(gameboard.gameboard[i][j]==null || gameboard.gameboard[i][j]!=piecetype){
                upperdiagonalMatch = false;
            }
        }
       for(int i=2,j=0;i>=0 && j<3;i--,j++){
            if(gameboard.gameboard[i][j]==null || gameboard.gameboard[i][j]!=piecetype){
                lowerdiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || upperdiagonalMatch || lowerdiagonalMatch;
   }
}