import java.util.*;

public class MyDeque<E>{
    public E[] data;
    public int size,first,last;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[]) new Object[10];
	first = 0;
	last = 0;
	size = 0;
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[]) new Object[initialCapacity];
	first = 0;
	last = 0;
	size = 0;
    }
    public int size(){
	return size;
    }

    public void addFirst(E val){
	if(val == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
	    resize();
	}
	if(size != 0){
	    first = (first - 1 + data.length) % data.length;
	}
	data[first] = val;
	size++;
    }

    public void addLast(E val){
	if(val == null){
	    throw new NullPointerException();
	}
	if(size == data.length){
	    resize();
	}
	if(size != 0){
	    last = (last + 1) % data.length;
	}
	data[last] = val;
	size++;
    }

    public E removeFirst(){
	if(size < 1){
	    throw new NoSuchElementException();
	}
        E removed = data[first];
	data[first] = null;
	if(size != 1){
	    first = (first + 1) % data.length;
	}
	size--;
	return removed;
    }

    public E removeLast(){
	if(size < 1){
	    throw new NoSuchElementException();
	}
	E removed = data[last];
	data[last] = null;
	if(size != 1){
	    last = (last - 1 + data.length) % data.length;
	}
	size--;
	return removed;
    }

    public E getFirst(){
	if(size < 1){
	    throw new NoSuchElementException();
	}
	return data[first];
    }

    public E getLast(){
	if(size < 1){
	    throw new NoSuchElementException();
	}
	return data[last];
    }
	
    @SuppressWarnings("unchecked")
    private void resize(){
	E[] temp = (E[]) new Object[size() * 2];
	for(int i = 0;i < data.length; i++){
	    temp[i] = data[(first + i)%data.length];
	}
	data = temp;
	first = 0;
	last = size - 1;
    }

    public String toString(){
	String result = "[";
	for(int i = first; i < last; i++){
	    result += data[i];
	}
	return result + "]";
    }


 
    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
    }

}

