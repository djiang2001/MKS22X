import java.util.*;
public class Merge{
    
    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    
    private static void msort(int[] data, int[] temp,int lo, int hi){
	for(int i = lo; i <= hi; i++){
	    temp[i] = data[i];
	}
	if(lo >= hi){
	    return;
	}
	int mid = (lo + hi)/ 2;
	msort(temp, data, lo, mid);
	msort(temp, data, mid + 1, hi);
	merge(data, temp, lo, mid, hi);
    }

    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	
	for(int i = lo; i < mid - 1 && mid - 1 <= hi; i++){
	    if(data[lo] <= data[mid+1]){
		temp[i] = data[lo];
		lo++;
	    }else if(data[mid+1] < data[lo]){
		temp[i] = data[mid+1];
		mid++;
	    }
	}
	for(int j = lo; j <= hi; j++){
	    data[j] = temp[j];
	}
	
    }
    
    public static void main(String[] args){
	int[] test ={1,6,3,8,5,6,7,5,7,8,5,4,2};
        mergesort(test);
	System.out.println(Arrays.toString(test));
    }
}
