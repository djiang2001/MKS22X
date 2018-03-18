import java.util.*;
public class Quick{

    /*    public static int partition1(int[] data, int start, int end){
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
    
    public static int quickselect1(int[] data, int k){
	int index = 0;
	int start = 0;
	int end = data.length-1;
	for(int i = 0; i < data.length; i++){
	    index = partition1(data, start, end);
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

    public static void quickSort1(int[] data){
	quickSortH1(data,0,data.length - 1);
    }

    public static void quickSortH1(int[] data, int low, int hi){
	if(low < hi){
	    int part = partition1(data,low,hi);
	    quickSortH1(data, low, part - 1);
	    quickSortH1(data, part + 1, hi);
	}

    } */
    //--NEW--//
    public static int[] partition(int[] data, int lo, int hi){
	int p = (int) (Math.random()*(hi - lo) + lo);
	//System.out.println(data[p]);
	int pivot = data[p];
	int i = lo;
	int lt = lo;
	int gt = hi;
	swap(data,p,lo);
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
	int[] parted = new int[]{lt,gt};
	return parted;
    }

    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int[] index = partition(data, start, end);
	for(int i = 0; i<data.length; i++){
	    if(index[0]<=k && index[1]>=k){
		return data[k];
	    }else if(k <= index[0]){
		end = index[0] - 1;
	    }else if(k > index[1]){
		start = index[1]+1;
	    }
	    index = partition(data, start, end);
	}
	return data[k];
    }
	
    public static void quicksort(int[] data){
	quicksortH(data,0,data.length-1);
    }

    public static void quicksortH(int[] data, int lo, int hi){
	if( lo < hi){
	    int[] part = partition(data,lo,hi);
	    quicksortH(data,lo,part[0] - 1);
	    quicksortH(data, part[1] + 1, hi);
	}

    }
    //--Basic--//
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
    
 
  public static void main(String[]args){
    int[] ary = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5};
    System.out.println(Quick.quickselect(ary,5) + " <- Should be 0");
    int[] ary1 = {9,5,8,7,5,6,5,-3,4,5,3,4,5,1,2,3,4,4,3,5,4,3};
    System.out.println(Quick.quickselect(ary1,19) + " <- Should be 7");
    System.out.println(Quick.quickselect(ary1,13) + " <- Should be 5");
    System.out.println(Quick.quickselect(ary1,0) + " <- Should be -3");
    System.out.println(Quick.quickselect(ary1,ary1.length-1) + " <- Should be 9");
    int[] ary2 = {3,6,1,2,4,6,8,99,1,2,32,45,123,-23,12,-30,-12,-3};
    Quick.quicksort(ary2);
    System.out.println("Your sorted array" + "\n" + Arrays.toString(ary2));
    System.out.println("The correct array\n[-30, -23, -12, -3, 1, 1, 2, 2, 3, 4, 6, 6, 8, 12, 32, 45, 99, 123]");
  }
}
