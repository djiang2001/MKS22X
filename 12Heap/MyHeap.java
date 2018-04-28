public class MyHeap{
    private int length;
    private String data[];
    private boolean isMax;
    
    MyHeap(){
	this(true);
    }

    MyHeap(boolean other){
	if(other){
	    isMax = true;
	}else {
	    isMax = false;
	}
	length = 0;
	data = new String[10];

    }

    public void swap(int index1, int index2){
	String temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }

    public void pushup(int index){
	if((isMax && data[index].compareTo(data[(index-1)/2]) > 0) ||
	   (!isMax && data[index].compareTo(data[(index-1)/2]) < 0)){
	    swap(index, (index -1)/2);
	    pushup((index-1)/2);
	}
    }

    public void pushdown(int index){
	int first = 2*index + 1;
	int sec = 2*index + 2;
	if(first < size() && sec < size()){
	    if(isMax && data[index].compareTo(data[first]) < 0 ||
	       !isMax && data[index].compareTo(data[first]) > 0){
		swap(index,first);
		pushdown(first);
	    }else
		if(isMax && data[index].compareTo(data[sec]) < 0 ||
		   !isMax && data[index].compareTo(data[sec]) > 0){
		    swap(index,sec);
		    pushdown(sec);
		}
	}
    }
    
    public void add(String str){
	if (size() == data.length){
	    resize();
	}
	data[size()] = str;
	pushup(size());
	length++;
    }

    public String remove(){
	String str = peek();
	swap(0, size()-1);
	length--;
	pushdown(0);
	return str;
    }

    public String peek(){
	return data[0];
    }

    public int size(){
	return length;
    }

    public void resize(){
	String[] temp = new String[2*size()];
	for(int i = 0; i < size(); i++){
	    temp[i] = data[i];
	}
	data = temp;
    }

    public String toString(){
	String result = "";
	for(int i = 0; i < size(); i++){
	    result += "[" + data[i] + "]";
	}
	return result;
    }

       public static void main(String[]args){

    }
}

