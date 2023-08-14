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
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            sc.close();
            String []values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]); 
            boolean success = gameboard.addPiece(inputRow, inputCol, p1.getPieceType());
            if(!success){
                 System.out.println("Invalid values, try again");
                 players.addFirst(p1);
                 continue;
            }
            players.addLast(p1);

        }
    }

}