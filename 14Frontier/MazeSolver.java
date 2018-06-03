import java.util.*;

public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
	animate = false;
    }

    //Default to BFS
    public boolean solve(){
	return solve(0);
    }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    //2: Priority
    public boolean solve(int mode){
	if(mode == 0){
	    frontier = new FrontierQueue();
	}
	else if(mode == 1){
	    frontier = new FrontierStack();
	}
   	else if(mode == 2){
	    frontier = new FrontierPriorityQueue();
	} else
	if(mode == 3){
	    frontier = new FrontierPriorityQueue();
	}

  	frontier.add(maze.getStart());
	Location end = maze.getEnd();
	
	while(frontier.hasNext()){
	    if(animate){
		clearTerminal();
		System.out.println(this);
		wait(50);
	    }

	    Location next = frontier.next();	
	    Location[] neighbors = maze.getNeighbors(next);
	    
	    maze.set(next.getX(), next.getY(), '.');

	    for(int i = 0; i < neighbors.length; i++){
		if(neighbors[i] != null){
		    if(neighbors[i].equals(end)){
			maze.set(end.getX(),end.getY(),'E');
			return true;
		    }else{ 
			frontier.add(neighbors[i]);
			maze.set(neighbors[i].getX(),neighbors[i].getY(),'?');
		    }
		}
	    }
	}
	return false;
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

     public String toString(){
    Location cur = maze.getEnd().getPrev();
    while (cur!=null){
      maze.set(cur.getX(),cur.getY(),'@');
      cur = cur.getPrev();
      if (animate){
        System.out.println("\033[2J\033[1;1H");
        System.out.println(maze.colorize(maze.toString()));
        wait(30);
      }
    }
    maze.set(maze.start.getX(),maze.start.getY(),'S');
    return maze.colorize(maze.toString());
  }

    public static void main(String [] args){
	/*	MazeSolver test = new MazeSolver("test.txt");
	System.out.println(test);
	test.setAnimate(true);
	test.solve(1);
	System.out.println(test);
	*/
    }
}

