import java.util.*;
public class RunningMedian{
    private int length;
    private MyHeap<Double> min;
    private MyHeap<Double> max;
    
    
    public RunningMedian(){
	length = 0;
	min = new MyHeap<Double>();
	max = new MyHeap<Double>(false);
    }

    public void add(Double data){
	if(size() == 0){
	    min.add(data);
	    length++;
	}
	Double median = getMedian();
	if(data > median){
	    max.add(data);
	    length++;
	} 
	if(data < median){
	    min.add(data);
	    length++;
	}
	if(data == median){
	    min.add(data);
	    length++;
	}
	if(max.size() - min.size() > 2){
	    min.add(max.remove());
	}
	if(min.size() - max.size() > 2){
	    max.add(min.remove());
	}
    }

    public Double getMedian(){
	if(length == 0){
	    throw new NoSuchElementException();
	}
	if(min.size() == max.size()){
	    return (min.peek() + max.peek()) / 2;
	}
	if(min.size() < max.size()){
	    return max.peek();
	} else
	{
	    return min.peek();
	}
    }

    public int size(){
	return length;
    }

    
}
