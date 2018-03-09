import java.util.*;
import java.io.*;
public class USACO{

    public static int bronze(String filename){
	int result = 0;
	try{
	    File f = new File(filename);
	    Scanner inf = new Scanner(f);
	    int r = inf.nextInt();
	    int c = inf.nextInt();
	    int e = inf.nextInt();
	    int n = inf.nextInt();
	    int[][] field = new int[r][c];
	    for(int i = 0; i < field.length; i++){
		for(int j = 0; j <field[i].length; j++){
		    field[i][j] = inf.nextInt();
		}
	    }
	    int r1;
	    int c1;
	    int d;
	    while(inf.hasNextLine()){
		int r1 = inf.nextInt();
		int c1 = inf.nextInt();
		int d = inf.nextInt();
		
				    

	    }
	    /* int[][] moves = int[n][3];
	    for(int row = 0; row < moves.length; row++){
		for(int col = 0; col < 3; col++){
		    moves[row][col] = inf.nextInt();
		}
	    }

	    for(int rows = 0; rows < moves.length; rows++){
		while(
		field[moves[row][0] - 1][
	    }
	    */
	    for(int a = 0; a < field.length; i++){
		for(int b = 0; b < field[a].length; b++){
		    result += field[a][b] - e
			}
	    }
		
	    
	}
	catch(FileNotFoundException e){
	    System.out.println("No such file");
	}

	    return result;
    }

    public static int silver(String filename){
	
    }

    public static void main(String[] args){
	System.out.println(bronze("Lake1.txt"));//342144
	System.out.println(bronze("Lake2.txt"));//103762432
	System.out.println(bronze("Lake3.txt"));//1058992704
	System.out.println(bronze("Lake4.txt"));//753121152
	System.out.println(bronze("Lake5.txt"));//1028282688
	System.out.println(bronze("Lake6.txt"));//72207936
	System.out.println(bronze("Lake7.txt"));//
	System.out.println(bronze("Lake8.txt"));// 
	System.out.println(bronze("Lake9.txt"));//
	System.out.println(bronze("Lake10.txt"));//211201344

	
	silver(file);
    }
}
