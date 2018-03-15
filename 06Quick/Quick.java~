import java.util.*;
public class Quick{

    public static int partition(int[] data, int start, int end){
	Random rand = new Random();
	int index = rand.nextInt(data.length);
	int pivot = data[index];
	int small = start + 1;
	int large = end;
	swap(data,index,start);
	while(small <= large){
	    if(data[small] <= pivot){
		small++;
	    }else if(data[small]> pivot){
		swap(data, small, large);
		large--;
	    }
	}
	swap(data,start,large);
	return large;
    }

      public static int quickselect(int[] data, int k){
	int index = 0;
	int start = 0;
	int end = data.length-1;
	for(int i = 0; i<data.length; i++){
	    index = partition(data, start, end);
	    if(index == k){
		return data[k];
	    }else if(k <= index){
		end = index-1;
	    }else if(k > index){
		start = index+1;
	    }
	}
	return data[k];
    }
    
    private static void swap(int[] data, int a, int b){
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }

    public static String toString(int[] data){
	String result = "[";
	for (int i = 0; i < data.length; i++){
	    if(i < data.length - 1){
	    result += data[i] + ", ";
	    }else{
	    result += data[i];
	    }
	}
	result += "]";
	return result;
    }
    
    public static void main(String[] args){
	int[] x = new int[] {15, 61, 57, 40, 83 ,12, 30, 87, 44, 69};
	System.out.println(partition(x, 0, 9));
	System.out.println(toString(x));
    }
}
