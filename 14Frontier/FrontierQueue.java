import java.util.*;

public class FrontierQueue implements Frontier{
    public Queue<Location> locations;    

    public FrontierQueue(){
	locations = new LinkedList<Location>();
    }
    
    public Location next(){
	return locations.remove();
    }
    
    public void add(Location l){
	locations.add(l);
    }

    public boolean hasNext(){
	return heap.size() >= 1;
    }
    
}
