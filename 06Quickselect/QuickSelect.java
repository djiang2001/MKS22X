public class QuickSelect{
    
    public int partition (int[] data, int start, int end){
	int pivot = data[end];
	int i = start - 1;
	for(int j = start; j <= end - 1; j++){
	    if(data[j] <= pivot){
		i++;
		swap(data[i], data[j], data);
	    }
	}
	return data[end];
    }
    
    void swap(int i, int j, int[] data) {
	int temp = data[i];
	data[i] = data[j];
	data[j] = temp;
    }

    public static void main(String[]args){
	int[] test = {1,3,4,5,6,72,4,3,6,23,4,2,5,6,};
    }


}
