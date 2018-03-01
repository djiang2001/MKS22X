import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default

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
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");

}



/*Wrapper Solve Function returns the helper function

  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

*/
public int solve(){

    //find the location of the S. 


    //erase the S


    //and start solving at the location of the s.

    //return solve(???,???);
    return 1;
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
private int solve(int row, int col){ //you can add more parameters since this is private

    if(animate){
	clearTerminal();
	System.out.println(this);
	wait(20);
    }

    //COMPLETE SOLVE

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


