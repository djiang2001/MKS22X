import java.util.*;

public class Sorts{
    public static void heapSort(int[] data){
	for(int i = data.length/2 - 1; i >= 0; i--){
	    heapify(data,data.length,i);
	}

	for(int i = data.length - 1;i >= 0; i--){
	    swap(data,0,i);
	    heapify(data,i,0);
	}
    }

    public static void swap(int[] data, int first, int sec){
	int temp = data[first];
	data[first] = data[sec];
	data[sec] = temp;
    }
    
    public static void heapify(int data[], int n, int count){
        int max = count;  
        int l = 2*count + 1;  
        int r = 2*count + 2;  
 
        if (l < n && data[l] > data[max]){
	    max = l;
	}
        if (r < n && data[r] > data[max]){
	    max = r;
	}
	
        if (max != count){
	    swap(data,count,max);
	    heapify(data, n, max);
	}
    }

    public String toString(int[] data){
	String result = "";
	for(int i =0;i < data.length; i++){
	    result+= "[" + data[i] + "]";
	}
	return result;
    }

    public static void main(String[]args){
    }

}
