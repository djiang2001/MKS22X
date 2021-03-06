import java.util.*;
public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	if(data.size() > 0){
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] pos = new MyLinkedListImproved[10];
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] neg = new MyLinkedListImproved[10];
	    for(int i = 0; i < 10; i++){
		pos[i] = new MyLinkedListImproved<Integer>();
		neg[i] = new MyLinkedListImproved<Integer>();
	    }
	    int maxPos = Math.abs(data.get(data.max()));
	    int minNeg = Math.abs(data.get(data.min()));
	    String combLength = ("" + Math.max(maxPos,minNeg));
	    int maxLength = combLength.length();
	    
	    for(int i = 0; i < maxLength; i++){
		for (Integer current : data){
		    if (current > 0){
			pos[findN(current,i)].add(current);
		    }
		    else {
			neg[findN(current,i)].add(current);
		    }
		}
		data.clear();
		for(int a = 0; a < 10; a++){
		    data.extend(neg[a]);
		}
		for(int b = 0; b < 10; b++){
		    data.extend(pos[b]);
		}
	    }
	}
    }
    public static int findN(int x, int i){
	int index;
	if(x > 0){
	    index  = (int) (x / Math.pow(10,i)) % 10;
	} else {
	    index = Math.abs(9-(int)(x*-1 / Math.pow(10, i)) % 10);
	}
	return index;
    }

     public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
    radixsort(data);
  }
}
