public class KnightBoard{
    private int[][] board;
    
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
    }
    
    public String toString(){
	String result = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		if(board[i][j] == 0){
		    result += "  -";
			} else{
	result += "  " + board[i][j];
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
