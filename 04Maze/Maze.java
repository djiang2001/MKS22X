import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default
    private int[] moveX = {0,1,0,-1};
    private int[] moveY = {1,0,-1,0};
    
    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	File f = new File(filename);
	setMaze(filename);
	    
	Scanner inf = new Scanner(f);
	int row = 0;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    for(int i = 0; i <line.length(); i++){
		maze[row][i] = line.charAt(i);
	    }
	    row++;
	} 		  
    }

public void setMaze(String filename)throws FileNotFoundException{
    File f = new File(filename);
    Scanner arrayer = new Scanner(f);
    int s = 0;
    int e = 0;
    int row = 0;
    int length = 0;
    while(arrayer.hasNextLine()){
	String line = arrayer.nextLine();
	for(int i = 0; i < line.length(); i++){
	    length = line.length();
	    if(line.charAt(i) == 'S'){
		s++;
	    }
	    if(line.charAt(i) == 'E'){
		e++;
	    }	     
	}
	row++;
    }


    if(s != 1 || e != 1){
	throw new IllegalStateException();
    }
    
    maze = new char[row][length]; 
}

private void wait(int millis){
    try {
	Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
}


public void setAnimate(boolean b){
    animate = b;
}


public void clearTerminal(){
    System.out.println("\033[2J\033[1;1H");
}



    public int solve(){
	int sRow = 0;
	int sCol = 0;
	for(int i = 0; i < maze.length; i++){
	    for(int j = 0; j < maze[i].length; j++){
		if(maze[i][j] == 'S'){
		    sRow = i;
		    sCol = j;
		}
	    }
	}
	maze[sRow][sCol] = ' ';
	return solve(sRow,sCol,0);
    }

    private boolean isEnd(int row, int col){
	return maze[row][col] == 'E';
    }
    
    private int solve(int row, int col, int count){
	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	if(isEnd(row,col)){
	    return count;
	}
	
	for(int i = 0; i < 4; i++){
	    if(maze[row+ moveX[i]][col + moveY[i]] == ' ' ||
		 maze[row+ moveX[i]][col + moveY[i]] == 'E'){
		if(maze[row][col] == ' '){
		    maze[row][col] = '@';
		}
		    return solve(row + moveX[i], col + moveY[i],count+1);
	    }
	}
	
	for(int i = 0; i < 4; i++){
	    if(maze[row+ moveX[i]][col + moveY[i]] == '@'){
		maze[row][col] = '.';
                maze[row + moveX[i]][col + moveY[i]] = ' ';
        	return solve(row + moveX[i], col + moveY[i],count-1);
	    }
	}

	return -1;
    }

public String toString(){
    String result = "";
    for(int i = 0; i < maze.length; i++){
	for(int j = 0; j < maze[i].length; j++){
	    result += maze[i][j];
	}
	result += "\n";
    }
    return result;
}

    public static void main(String[]args){
        Maze f;
	try{
        f = new Maze("Maze3.txt");//true animates the maze.
        f.setAnimate(true);
		System.out.println(f.solve());
        System.out.println(f);

	}
	catch(FileNotFoundException e){
	}
    }
}
