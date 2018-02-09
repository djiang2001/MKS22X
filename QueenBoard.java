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

    //-
    private boolean addQueen(int r, int c){
	board[r][c] = -1;
        for(int i = c + 1; i < size - c ; i++){
	    board[r][i] += 1;
	}

	for(int j = r + 1; j < size - c - 1 ; j++){
	    board[j][c] += 1;
	}

	for(int a = 1; a < size - c - 1; a++){
	    board[r + a][c + a] += 1;
	}
	
	return true;
    }

    private boolean removeQueen(int r, int c){
	board[r][c] = 0;
	return true;
    }

    public String toString(){
	String result = "";
	for(int i = 0; i < size; i++){
	    for(int j = 0; j < size; j++){
		if(board[i][j] == -1){
		    result += "[Q]";
		    }else
		    if(board[i][j] == 0){
			result += board[i][j];//"[-]";
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
	test.addQueen(1,2);
		System.out.println(test);
			System.out.println(test);
				System.out.println(test);
    }
}
