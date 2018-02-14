public class QueenBoard{
  private int[][] board;
  private int size;
    
  //--Constructor--//
  public QueenBoard(int size){
    board = new int[size][size];
    this.size = size;
    for(int i = 0; i < size;i++){
	    for(int j = 0; j < size; j++){
        board[i][j] = 0;
	    }
    }
  }

  //-Private Methods-//
  private boolean addQueen(int r, int c){
    if(board[r][c] == 0){
	    board[r][c] = -1;
	    for(int i = 1; c < size - i; i++){
        board[r][c+i] += 1;
        if (r < size - i){
          board[r+i][c+i] += 1;
        }
        if (r >= i){
          board[r-i][c+i] += 1;
        }
      }
      return true;
    }
    return false;
  }

  private boolean removeQueen(int r, int c){
    if(board[r][c] == -1){
      board[r][c] = 0;
      for (int i=1; c<size - i; i++){
        board[r][c+i] -= 1;
        if (r < size - i){
          board[r+i][c+i] -= 1;
        }
        if (r >= i){
          board[r-i][c+i] -= 1;
        }
      }
      return true;
    }
    return false;
  }

  public boolean solve(){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(board[i][j] != 0){
          throw new IllegalStateException();  
        }
      }
    }
    return solveM(size);
  }

  public boolean solveM(int col){
    if(col == size){
      return true;
    }
    for(int i = 0; i < size; i++){
      if(addQueen(col,i)){
        if(solveM(col + 1)){
          return true;
        }
       removeQueen(col,i);
      }
    }
    return false;
  }

  public int countSolutions(){
    for(int i = 0;i < size; i++){
      for(int j = 0; j < size; j++){
        if(board[i][j] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return countM(0);
    }

  public int countM(int col){
    int result = 0;
    if(col == size){
      return 1;
    }
    for (int row = 0; row < board.length; row++) {
	    if (addQueen(row,col)) {
        result += countM(col + 1);
        removeQueen(row,col);
	    }
    }
    return result;
  }
  
  public String toString(){
    String result = "";
    for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
        if(board[i][j] == -1){
          result += "[Q]";
		    }else
          if(board[i][j] == 0){
            result += "[-]";
          }
          else{
            result += "[" + board[i][j] + "]"; 
          }
	    }
      result += "\n";
    }
    return result;
  }
    
  public static void main(String[]args){
  QueenBoard b = new QueenBoard(10);
    System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution
    try{
    b.solve();
    }catch(IllegalStateException e){
    System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"
    try{
    b.countSolutions();
    }catch(IllegalStateException e){
    System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"
    for (int i = 0; i < 12; i++){
    QueenBoard a = new QueenBoard(i);
    System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
    /*          Expected Values
    i --> # of Solutions   i --> # of Solutions
    0 --> 1                      6 --> 4
    1 --> 1                      7 --> 40
    2 --> 0                      8 --> 92
    3 --> 0                      9 --> 352
    4 --> 2                    10 --> 724
    5 --> 10                  11 --> 2680
  */
    System.out.println(a); //prints out an empty i by i grid of underscores
    }
  }
}
