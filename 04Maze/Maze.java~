import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default
    private int[] moveX = {0,1,0,-1};
    private int[] moveY = {1,0,-1,0};
    public int solution = 0;
    
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
	return solve(sRow,sCol);
    }

/*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.


  Postcondition:

  The S is replaced with '@' but the 'E' is not.

  All visited spots that were not part of the solution are changed to '.'

  Note: This is not required based on the algorithm, it is just nice visually to see.
  All visited spots that are part of the solution are changed to '@'
*/
    private int solve(int row, int col){
	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}
	
	if(maze[row][col] == 'E'){
	    return solution;
	}
	
	for(int i = 0; i < 4; i++){
	    if(!(maze[row+ moveX[i]][col + moveY[i]] == '@' ||
		 maze[row+ moveX[i]][col + moveY[i]] == '.' ||
		 maze[row+ moveX[i]][col + moveY[i]] == '#')){
                maze[row+ moveX[i]][col + moveY[i]] = '@';
        	return solve(row + moveX[i], col + moveY[i]);
	    }
	} 
	maze[row][col] = '.';
	return -1; //so it compiles
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
        f = new Maze("Maze1.txt");//true animates the maze.
        f.setAnimate(true);
        f.solve();
        System.out.println(f);
	}
	catch(FileNotFoundException e){
	}
    }
}


