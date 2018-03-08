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
	    System.out.println("No such file");
	}
	
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
