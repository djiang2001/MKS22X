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

    public static void main(String[] args){
	System.out.println(bronze("Lake1.txt"));
	System.out.println(bronze("Lake2.txt"));
	System.out.println(bronze("Lake3.txt"));
	System.out.println(bronze("Lake4.txt"));
	System.out.println(bronze("Lake5.txt"));
	System.out.println(bronze("Lake6.txt"));
	System.out.println(bronze("Lake7.txt"));
	System.out.println(bronze("Lake8.txt"));   
	System.out.println(bronze("Lake9.txt"));
	System.out.println(bronze("Lake10.txt"));
	
	silver(file);
    }
}
