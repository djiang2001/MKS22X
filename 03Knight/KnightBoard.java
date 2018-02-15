public class KnightBoard{
    private int[][] board;
    private int length;
    private final int[] moveX = {-1,1,-2,-2,-1,1,2,2};
    private final int[] moveY = {1,-1,-1,1,2,2,-1,1};
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	length = startingRows * startingCols;
    }

    public boolean solve(int startingRow, int startingCol){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if(board[i][j] != 0){
		    throw new IllegalStateException();
			}
		if(startingRow > board.length || startingCol > board[i].length){
		    throw new IllegalArgumentException();
		}
	    }
	}
	return solveH(startingRow,startingCol,1);
    }

    private boolean solveH(int row, int col, int level){
	boolean result = false;
	if(board[row][col] != 0 || level > length){
	    for(int i = 0; i < board.length; i++){
		for(int j = 0; j < board[i].length; j++){
		    result = result || (board[i][j] != 0);
		    //board[i][j] = 0;
		    level = 1;
		}
	    }
	}else{
	    board[row][col] = level;
	    for(int a = 0; a < 8; a++){
		    result = result || solveH(row + moveX[a], col + moveY[a], level + 1);
		}
	    }
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
	KnightBoard test = new KnightBoard(2,2);
	//	test.solve(2,2);
	System.out.println(test.solve(0,0));
    }
}
