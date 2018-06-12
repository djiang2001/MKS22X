public class Location implements Comparable<Location>{
    private int x,y,startDist,priority;
    private Location previous;
    
    public Location(int _x, int _y, Location prev, int priority, int dist){
	x = _x;
	y = _y;
	previous = prev;
	this.priority = priority;
	startDist = dist;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public int getDistance(){
	return startDist;
    }

    public void setDistance(int d){
	startDist = d;
    }
	
    public Location getPrev(){
	return previous;
    }

    public void setPrev(Location prev){
	previous = prev;
    }

    public int compareTo(Location l){
	return getPriority() - l.getPriority();
    }

    public boolean equals(Location l){
	return x == l.getX() && y == l.getY();
    }

    public int getPriority(){
	return priority;
    }
    
}
