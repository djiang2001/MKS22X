public class MyDeque<T>{
    private T[] data;
    private int start,end;

    @SuppressWarnings("unchecked")
    public Deque(){
	data = (T[])new Object[10];
	start = 0;
	end = 0;
    }

    publicMyDeque(int initialCapacity){
	if(initialCapacity <= 0){
	    throw new IllegalArgumentException();
	}
	data = (T[]) new Object[initialCapacity];
	start = 0;
	end = 0;
    }

    public int size(){
	return data.length;
    }

    public void addFirst(T data){
	if(data == null){
	    throw new NullPointerException();
	}
	if(size() + start - 1 = end){
	    resize();
	}else {
	    start--;
	    data[size()+ start] = data;
	}
    }

    private void resize(){
	private T[] temp = (T[]) new Object[data.size() * 2];
	for(int i = 0;i < temp.length; i++){
	    temp[i] = data[first + i];
	}

    }
    public String toString(){
	String result = "[";
	for(int i = start; i < end; i++){
	    result += data[i];
	}
	return result + "]";
    }
    
}
