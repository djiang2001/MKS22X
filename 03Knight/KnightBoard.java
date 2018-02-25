public class KnightBoard{
  private int[][] board;
  private int rows,cols;
  private final int[] moveX = {-2,-2,-1,-1,1,1,2,2,};
  private final int[] moveY = {-1,1,-2,2,-2,2,-1,1};
    
  public KnightBoard(int startingRows, int startingCols){
    if(startingRows < 0 || startingCols < 0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
  }

  public boolean solve(int startingRow, int startingCol){
    for(int i = 0; i < rows; i++){
	    for(int j = 0; j < cols; j++){
        if(board[i][j] != 0){
          throw new IllegalStateException();
        }
      }
    }
     if(startingRow >= rows || startingCol >= cols || startingRow < 0 || startingCol < 0){
          throw new IllegalArgumentException();
          } 
    return solveH(startingRow,startingCol,1);
  }

 private boolean solveH(int row, int col, int level){
    board[row][col] = level;
    if (level == rows*cols){
      return true;
    }
    for (int i = 0; i < 8; i++){
      int nextRow = row + moveX[i];
      int nextCol = col + moveY[i];
      if ((!(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols)
           && (board[nextRow][nextCol] == 0))){
        if (solveH(nextRow, nextCol, level+1)){
          return true;
        }
        board[nextRow][nextCol] = 0;
      }
    }
    board[row][col] = 0;
    return false;
}
  
  private int countSolutions(int startingRow, int startingCol){
    for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] != 0){
          throw new IllegalStateException();
        }
      }
		}
    if (startingRow > rows || startingCol > cols || startingRow < 0 || startingCol < 0){
      throw new IllegalArgumentException();
    }
    return countH(startingRow,startingCol,1);
  }

  private int countH(int row, int col, int level){
    int result = 0;
    board[row][col] = level;
    if(level == rows * cols){
      return 1;
    }
    for(int i = 0; i < 8; i++){
      int nextRow = row + moveX[i];
      int nextCol = col + moveY[i];
      if((!(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols)
          && (board[nextRow][nextCol] == 0))){
        result += countH(nextRow,nextCol,level + 1);
        board[nextRow][nextCol] = 0;
      }
    }
    board[row][col] = 0;
    return result;
  }
  
  public String toString(){
    String result = "";
    for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
        if(board[i][j] == 0){
          result += "  -";
        } else
          if(board[i][j] < 10){
            result += "  " + board[i][j];
          }else{
            result += " " + board[i][j];
          }
	    }
	    result += "\n";
    }
    return result;
	}
    
  public static void main(String[]args){
    KnightBoard a = new KnightBoard(3,3);

    System.out.println(a);
    /* Prints
      _ _ _
      _ _ _
      _ _ _
    */
    try{
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (a.solve(i,j)){
          System.out.println("There is an error with your solve method");
        }
      }
    }} catch (IllegalStateException e){
    }//prints nothing
    try{
    System.out.println(a.countSolutions(0,0)); //prints 0
    } catch (IllegalStateException e){
    }



    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b.solve(0,0)); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"
    
    try{
	b.countSolutions(0,0);
    }catch(IllegalStateException e){
	System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      KnightBoard b1 = new KnightBoard(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    /*try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(0,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
    
    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"
    */


    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        KnightBoard abc = new KnightBoard(5,5);
        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
      }
    }
    
    KnightBoard c = new KnightBoard(5,5);

    int totalSol = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        totalSol += c.countSolutions(i,j);
      }
    }

    System.out.println(totalSol); //prints 1728

    KnightBoard d = new KnightBoard(5,5);
System.out.println(d.countSolutions(0,0)); //prints 304
  }
}
