public class msGame {

   private char[][] ba = new char[10][10];
   private char[][] ca = new char[10][10];
   public boolean gameOn;
   
   public msGame(){
   gameOn=false;
      for (int i=0 ; i<10 ; i++){
         for(int j=0 ; j<10 ; j++){
            ca[i][j] = ' ';
         }
      }
      
      ba[0][1] = 'X'; //1
      ba[1][1] = 'X'; //2
      ba[1][2] = 'X'; //3
      ba[2][3] = 'X'; //4
      ba[3][5] = 'X'; //5
      ba[5][8] = 'X'; //6
      ba[8][1] = 'X'; //7
      ba[3][2] = 'X'; //8
      ba[1][3] = 'X'; //9
      ba[4][5] = 'X'; //10
      ba[9][8] = 'X'; //11
      ba[9][0] = 'X'; //12
      ba[0][9] = 'X'; //13
      ba[1][8] = 'X'; //14
      ba[3][7] = 'X'; //15
      
      for(int i=0; i<10 ; i++){
         for(int j=0; j<10 ; j++){
            if(ba[i][j] != 'X'){
            int count = 0;
               if(i-1>=0 && j-1>=0){if(ba[i-1][j-1]=='X'){count++;}}
               if(i-1>=0)          {if(ba[i-1][j]=='X'){count++;}}
               if(i-1>=0 && j+1<=9){if(ba[i-1][j+1]=='X'){count++;}}
               if(j-1>=0)          {if(ba[i][j-1]=='X'){count++;}}
               if(j+1<=9)          {if(ba[i][j+1]=='X'){count++;}}
               if(i+1<=9 && j-1>=0){if(ba[i+1][j-1]=='X'){count++;}}
               if(i+1<=9)          {if(ba[i+1][j]=='X'){count++;}}
               if(i+1<=9 && j+1<=9){if(ba[i+1][j+1]=='X'){count++;}}
            ba[i][j] = Character.forDigit(count,10);
            }
         }
      }
   }
   
   public void gameOn(){
      gameOn = true;
   }
   
   public void gameOff(){
      gameOn = false;
   }
   
   public void getBoard(){
      System.out.println("++===++===+===+===+===+===+===+===+===+===+===++");
      System.out.println("||   || 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 ||");
      System.out.println("++===++===+===+===+===+===+===+===+===+===+===++");
      for(int i=0 ; i<10 ; i++){
      System.out.println("|| " + i + " || "+ca[i][0]+" | "+ca[i][1]+" | "+ca[i][2]+" | "+ca[i][3]+" | "+ca[i][4]+" | "+ca[i][5]+" | "+ca[i][6]+" | "+ca[i][7]+" | "+ca[i][8]+" | "+ca[i][9]+" ||");
      System.out.println("++---++---+---+---+---+---+---+---+---+---+---++");
      }
      System.out.println("++===++===+===+===+===+===+===+===+===+===+===++");
   }
   
   public boolean isValidMove(int row, int col){
      if(row>=0 && row<=9 && col>=0 && col<=9){
         if(ca[row][col] == ' '){
            return true;
         }else{
            return false;
         }
      }else{
         return false;
      }
   }
   
   public void markSquare(int row, int col){
      if(isValidMove(row, col)){  
         if(ba[row][col] == 'X'){
            System.out.println("\nYou stepped on a bomb!!\n");
            System.out.println("\n\n\nAAAAAAAAAA\n\n\nKABOOM\n\n\n");
            ca[0][1] = 'X'; //1
            ca[1][1] = 'X'; //2
            ca[1][2] = 'X'; //3
            ca[2][3] = 'X'; //4
            ca[3][5] = 'X'; //5
            ca[5][8] = 'X'; //6
            ca[8][1] = 'X'; //7
            ca[3][2] = 'X'; //8
            ca[1][3] = 'X'; //9
            ca[4][5] = 'X'; //10
            ca[9][8] = 'X'; //11
            ca[9][0] = 'X'; //12
            ca[0][9] = 'X'; //13
            ca[1][8] = 'X'; //14
            ca[3][7] = 'X'; //15
            
            System.out.println("\n\nrun the program again to give it another try.");
            gameOff();   
         } 
         else if(ba[row][col] == '0'){
         ca[row][col] = ba[row][col];
            markSquare(row-1,col-1);
            markSquare(row-1,col);
            markSquare(row-1, col+1);
            markSquare(row, col-1);
            markSquare(row, col+1);
            markSquare(row+1, col-1);
            markSquare(row+1, col);
            markSquare(row+1, col+1);
         } else {
        ca[row][col] = ba[row][col];
         }
      }      
   }
   
   public void flagSquare(int row, int col){
      if(isValidMove(row, col)){
      ca[row][col] = 'F';
      }
   }
   
   public void unFlagSquare(int row, int col){
      if(ca[row][col] == 'F'){
         ca[row][col] = ' ';
      }else{
         System.out.println("That spot isn't flagged in the first place");
      }
   }
      
      
   

}
// | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
// | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
// +---+---+---+---+---+---+---+---+---+---+