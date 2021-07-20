import java.util.Scanner;

public class MinesweeperMain{

   public static void main(String[] argybois){
   
      msGame ms = new msGame();
      Scanner input = new Scanner(System.in);
      int row;
      int col;
      int flagRow;
      int flagCol;
      int unFlagRow;
      int unFlagCol;

      
      System.out.println("Welcome to easy Minesweeper!\nThis is your empty board\n");
      
      ms.getBoard();
      
      ms.gameOn();
      
         while(ms.gameOn){
            System.out.println("\nenter 2 integers b/w 0 & 9 consecutively separated by a space to make a move.");
            System.out.println("\nenter -1 twice to initiate a flagging. enter -2 twice to inititate an unflagging");
            row = input.nextInt();
            col = input.nextInt();
               if((row == -1 && col == -1)||(row == -2 && col == -2)){
                  if(row == -1 && col == -1){
                  System.out.println("enter flagging coordinates");
                  flagRow = input.nextInt();
                  flagCol = input.nextInt();
                  ms.flagSquare(flagRow,flagCol);
                  System.out.println("moving on\n\n\n");
                  } else if(row == -2 && col == -2){
                  System.out.println("enter unflagging coordinates");
                  unFlagRow = input.nextInt();
                  unFlagCol = input.nextInt();
                  ms.unFlagSquare(unFlagRow,unFlagCol);
                  System.out.println("moving on\n\n\n");
                  }
               }else if(!ms.isValidMove(row, col)){
               System.out.println("invalid move, no change in board\n\n\n");
               }
            
            ms.markSquare(row, col);
            ms.getBoard();
            
         
         
         }
   
 
 
 
   }
}