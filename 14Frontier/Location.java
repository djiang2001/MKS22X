public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceToEnd;
    
    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public int getDistance(){
	return distanceToEnd;
    }

    public void setDistance(int d){
	distanceToEnd = d;
    }
	
    public Location getPrev(){
	return previous;
    }

    public void setPrev(Location prev){
	previous = prev;
    }

    public int compareTo(Location l){
	if(getDistance() > l.getDistance()){
	    return 1;
	} else if(getDistance() == l.getDistance()){
	    return 0;
	}else{
	    return -1;
	}
    }
    
}
