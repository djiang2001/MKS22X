import java.util.*;
import java.io.*;

public class FrontierPriorityQueue implements Frontier{
    
    @SuppressWarnings("unchecked")
    private MyHeap<Location> heap;

    @SuppressWarnings("unchecked")
    public FrontierPriorityQueue(){
	heap = new MyHeap(false);
    }
    
    public Location next(){
	return heap.remove();
    }

    public void add(Location n){
	heap.add(n);
    }

    public boolean hasNext(){
	return heap.size() > 0;
    }

    public String toString(){
	return heap.toString();
    }

}
