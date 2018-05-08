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
	    return;
	}

	if(data > max.peek()){
	    max.add(data);
	} else{
	    min.add(data);
	}
	
	if(Math.abs(max.size() - min.size()) > 1){
	    if(min.size() > max.size()){
		max.add(min.remove());
	    }
	    else{
		min.add(max.remove());
	    }
	}
	length++;
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

    public static void main(String[] args){
	RunningMedian median = new RunningMedian();
	median.add(12.3);
	median.add(11.2);
	median.add(15.5);
	median.add(17.3);

	System.out.println("" + median.getMedian());
    }
}
