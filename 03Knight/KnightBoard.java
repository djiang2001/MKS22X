public class KnightBoard{
    private int[][] board;
    private final int[] moveX = new int[4];
    moveX[0] = -1;
    moveX[1] = 1;
    moveX[2] = -2;
    moveX[3] = 2;
    moveX[4] = -1;
    moveX[5] = 1;
    moveX[6] = -2;
    moveX[7] = 2;
    private final int[] moveY = new int[4];
    moveX[0] = -1;
    moveX[1] = 1;
    moveX[2] = -2;
    moveX[3] = 2;
    moveX[4] = -1;
    moveX[5] = 1;
    moveX[6] = -2;
    moveX[7] = 2;
    
    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
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
	return true; //solveH(int row, int col, int level)
    }

    private boolean solveH(int row, int col, int level){
	if(!solveH(row,col,level)){

	}
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
	KnightBoard test = new KnightBoard(5,5);
	System.out.println(test);
    }
}
