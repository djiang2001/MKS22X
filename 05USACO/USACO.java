import java.util.*;
import java.io.*;
public class USACO{

    public static int bronze(String filename){
	try{
	    File f = new File(filename);
	    Scanner inf = new Scanner(f);
	    int r = inf.nextInt();
	    int c = inf.nextInt();
	    int e = inf.nextInt();
	    int n = inf.nextInt();
	    int[][] field = new int[r][c];
	    for(int i = 0; i <field.length; i++){
		for(int j = 0; j <field[i].length; j++){
		    maze[i][j] = inf.nextInt();
		}
	    }

	    
	    
	}
	catch(FileNotFoundException e){
	}
	
    }

    public static int silver(String filename){

    }
    
}
