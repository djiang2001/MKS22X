import java.util.*;
public class Merge{

    public static void insertionSort(int[] data,int lo, int hi){
	for(int i = 0;i<ary.length;i++){
	    int temp = ary[i];
	    int j = i - 1;
	    while(j >= 0 && temp < ary[j]){
		ary[j+1] = ary[j];
		j--;
	    }
	    ary[j+1] = temp;
	}
    }
    
    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    
    private static void msort(int[] data, int[] temp,int lo, int hi){
	if(lo < hi){
	    for(int i = lo; i <= hi; i++){
		temp[i] = data[i];
	    }
	   int mid = (lo + hi)/ 2;
	    msort(temp, data, lo, mid);
	    msort(temp, data, mid + 1, hi);
	    merge(data, temp, lo, mid, hi);
	}
    }

    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
	int k = lo;
        while (i <= mid && j <= hi) {
            if (data[i] <= data[j]) {
                temp[k] = data[i];
                i++;
	    } else {
                temp[k] = data[j];
                j++;
		}
		k++;
		
        }
        while (i < mid + 1) {
            temp[k] = data[i];
            k++;
            i++;
        }
	while(j <= hi){
	    temp[k] = data[j];
	    j++;
	    k++;
	}	
	for(int a = lo; a <= hi; a++){
	    data[a] = temp[a];
	}
    }
    
    public static void main(String[] args){
	int[] test =new int[]{1,6,3,8,5,6,7,5,7,8,5,4,2};
        mergesort(test);
	System.out.println(Arrays.toString(test));
    }
}
