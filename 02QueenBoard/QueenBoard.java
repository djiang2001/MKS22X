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
	    for(int i = c + 1; i < size ; i++){
		board[r][i] += 1;
	    }
	    for(int a = 1; a < size - c; a++){
		board[r + a][c + a] += 1;
	    }
	    for(int b = 1; b < c ; b++){
		board[r - b][c - b] += 1;
	    }
	    return true;
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	if(board[r][c] == -1){
	    board[r][c] = 0;
	    for(int i = c + 1; i < size ; i++){
		board[r][i] -= 1;
	    }
	    for(int a = 1; a < size - c; a++){
		board[r + a][c + a] -= 1;
	    }
	    return true;
	}
	return false;
    }

    public boolean solve(){
	return true;
    }

    public int countSolutions(){
	return 1;
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
	QueenBoard test = new QueenBoard(5);
	System.out.println(test);
	test.addQueen(1,1);
	test.addQueen(1,2);
	//	test.removeQueen(1,1);
		System.out.println(test);
			System.out.println(test);
				System.out.println(test);
    }
}
