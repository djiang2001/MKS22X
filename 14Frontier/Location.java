public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distanceToEnd;
    
    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public static int getX(){
	return x;
    }

    public static int getY(){
	return y;
    }

    public getDistance(){
	return distanceToEnd;
    }

    public setDistance(int d){
	distanceToEnd = d;
    }
	
    public Location getPrev(){
	return previous;
    }

    public int compareTo(Location l){
	if(getDistance() > l.getDistance()){
	    return 1;
	} else if(getDistance() == l.getDistance()){
	    return 0;
	}else
	    {
		return -1;
	    }
    }
    
}
