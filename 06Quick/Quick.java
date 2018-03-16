import java.util.*;
public class Quick{

     public static int partition(int[] data, int start, int end){
	int index = (int) Math.random()*(end - start + 1) + start;
	int pivot = data[index];
	int small = start + 1;
	int large = end;
	swap(data,index,start);
	while(small <= large){
	    if(data[small] <= pivot){
		small++;
	    }else{
		swap(data, small, large);
		large--;
	    }
	}
	swap(data,start,large);
	return large;
    }

    public static int part(int[] data, int lo, int hi){
	int i = (int) (Math.random()*hi - lo + 1) + lo;
	System.out.println(data[i]);
	int pivot = data[i];
	int lt = lo;
	int gt = hi;
	swap(data,i,lo);
	while(i <= gt){ 
	    if(data[i] == pivot){
		i++;
	    }else
		if(data[i] > pivot){
		    swap(data, i, gt);
		    gt--;
		}else{
		    swap(data, i, lt);
		    lt++;
		    i++;
		}
	}
	return data[lt];
    }

    
      public static int quickselect(int[] data, int k){
	int index = 0;
	int start = 0;
	int end = data.length-1;
	for(int i = 0; i < data.length; i++){
	    index = partition(data, start, end);
	    if(index == k){
		return data[k];
	    }else if(k <= index){
		end = index - 1;
	    }else if(k > index){
		start = index + 1;
	    }
	}
	return data[index];
    }

    public static void quickSort(int[] data){
	quickSortH(data,0,data.length - 1);
    }

    public static void quickSortH(int[] data, int low, int hi){
	if(low < hi){
	    int part = partition(data,low,hi);
	    quickSortH(data, low, part - 1);
	    quickSortH(data, part + 1, hi);
	}

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
	//	int[] test = new int[] {1 , 61, 57, 40, 83,100,100,100,100,100,100 ,12, 30, 87, 44, 69};
	int[] test = new int[] {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5};
	System.out.println(part(test, 0, 14));
	System.out.println(toString(test));
	//	Quick.quickSort(test);
	//	System.out.println(toString(test));
	/*	for (int i = 0; i < 6; i++){
		int[] ary = {2,10,15,23,0,5};
		System.out.println(Quick.quickselect(ary,i));
		} */
    } 
}
