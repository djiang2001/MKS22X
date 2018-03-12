import java.util.*;
import java.io.*;
public class USACO{

    public static int bronze(String filename){
	int depth = 0;
	int elevation = 0;
	try{
	    File f = new File(filename);
	    Scanner inf = new Scanner(f);
	    int r = inf.nextInt();
	    int c = inf.nextInt();
	    elevation = inf.nextInt();
	    int n = inf.nextInt();
	    int [][] field = new int[r][c];
	    int[][] herd = new int[n][3];
	    for(int i = 0; i < field.length; i++){
		for(int j = 0; j < field[i].length; j++){
		    field[i][j] = inf.nextInt();
		}
	    }
	    for (int i=0; i < n; i++){
		int r1 = inf.nextInt()-1;
		int c1 = inf.nextInt()-1;
		int d = inf.nextInt();
		int highest = 0;
		for (int a = r1; a < r1+3; a++){
		    for (int b = c1; b < c1 + 3; b++){
			int current = field[a][b];
			if (highest < current){
			    highest = current;
			}
		    }
		}
		int newDepth = highest - d;
		for (int a = r1; a < r1 + 3; a++){
		    for (int b = c1; b < c1+3; b++){
			if (field[a][b] > newDepth){
			    field[a][b] = newDepth;
			}
		    }
		}
	    }	
	    for(int i = 0; i< field.length ; i++){
		for(int j = 0; j<field[i].length; j++){
		    if(field[i][j]<= elevation){
			field[i][j]= elevation - field[i][j];
			depth += field[i][j];
		    }
		}
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	return depth * 72 * 72;
    }

    public static int silver(String filename){
	int[][] current,previous;
	char[][] map;
	try{
	    File f = new File(filename);
	    Scanner inf = new Scanner(f);

	    int row = inf.nextInt();
	    int col = inf.nextInt();
	    int steps = inf.nextInt();

	    map = new char[row][col];
	    current = new int[row][col];
	    previous = new int[row][col];

	    for(int i = 0; i < row; i++){
		String line = inf.next();
		for(int j = 0; j < col; j++){
		    map[i][j] = line.charAt(j);
		}
	    }
	    int sRow = inf.nextInt()-1;
	    int sCol = inf.nextInt()-1;
	    int eRow = inf.nextInt()-1;
	    int eCol = inf.nextInt()-1;

	    previous[sRow][sCol] = 1;

	    
	    for (int i = 0; i < steps; i++){
		for (int r = 0; r < row; r++){
		    for (int c = 0; c < col; c++){
			if (map[r][c] != '*'){
			    int area = 0;
			    if(r+1 >= 0 && c >= 0 && r + 1 < row && c < col){
				area += previous[r+1][c];
			    }
			    if(r - 1 >= 0 && c >= 0 && r - 1  < row && c < col){
				area += previous[r-1][c];
			    }
			    if(r >= 0 && c + 1 >= 0 && r < row && c + 1 < col){
				area += previous[r][c+1];
			    }
			    if(r >= 0 && c - 1 >= 0 && r < row && c - 1 < col){
				area += previous[r][c-1];
			    }
			    current[r][c] = area;
			}
		    }
		}
	        previous = current;
		current = new int[row][col];
	    }
      
	    return previous[eRow][eCol];
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	    
	return 0;
    }

    public static void main(String[] args){
	System.out.println(bronze("Lake1.txt"));//342144
	System.out.println(bronze("Lake2.txt"));//103762432
	System.out.println(bronze("Lake3.txt"));//1058992704
	System.out.println(bronze("Lake4.txt"));//753121152
	System.out.println(bronze("Lake5.txt"));//1028282688
	System.out.println(bronze("Lake6.txt"));//72207936

	System.out.println(silver("Ctravel1.txt"));//1
	System.out.println(silver("Ctravel2.txt"));//74
	System.out.println(silver("Ctravel3.txt"));//6435
	System.out.println(silver("Ctravel4.txt"));//339246
	System.out.println(silver("Ctravel5.txt"));//0
	System.out.println(silver("Ctravel6.txt"));//14396412
	System.out.println(silver("Ctravel7.txt"));//1533810
	System.out.println(silver("Ctravel8.txt"));//456055
	System.out.println(silver("Ctravel9.txt"));//28
	System.out.println(silver("Ctravel10.txt"));//1321670
    }
}
