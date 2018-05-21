import java.util.*;

public class MyHeap<T extends Comparable<T>>{
    private int length;
    private T[] data;
    private boolean isMax;

    
    MyHeap(){
	this(true);
    }

    @SuppressWarnings("unchecked")
	MyHeap(boolean other){
	if(other){
	    isMax = true;
	}else {
	    isMax = false;
	}
	length = 0;
	data = (T[]) new Comparable[10];

    }

    public void swap(int index1, int index2){
	T temp = data[index1];
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
        if(isMax && first < size() && data[index].compareTo(data[first]) < 0 && (sec >= size() || data[sec].compareTo(data[first]) <= 0) ||
	   !isMax && first < size() && data[index].compareTo(data[first]) > 0 && (sec >= size() || data[sec].compareTo(data[first]) >= 0)){
	    swap(index,first);
	    pushdown(first);
	}else
	    if(isMax && sec < size() && data[index].compareTo(data[sec]) < 0 && (first >= size() || data[first].compareTo(data[sec]) <= 0) ||
	       !isMax && sec < size() && data[index].compareTo(data[sec]) > 0 && (first >= size() || data[first].compareTo(data[sec]) >= 0)){
		swap(index,sec);
		pushdown(sec);
	    }
    }

    
    public void add(T str){
	if (size() == data.length){
	    resize();
	}
	data[size()] = str;
	pushup(size());
	length++;
    }

    public T remove(){
	T str = peek();
	swap(0,size() - 1);
	length--;
	pushdown(0);
	return str;
    }

    public T peek(){
	return data[0];
    }

    public int size(){
	return length;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	T[] temp = (T[]) new Comparable[2*size()];
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

