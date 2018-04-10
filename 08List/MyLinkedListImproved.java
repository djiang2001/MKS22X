public class MyLinkedListImproved<T> implements Iterable<T>{
 private Node first, last;
    private int length;

    //Important Method
    private Node getNode(int index){
	Node current = first;
	if(index == length - 1){
	    return last;
	}
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current;
    }

    //Constructor
    public MyLinkedListImproved(){
	length = 0;
    }

    public String toString(){
	String result = "[";
	Node current = first;
	for(int i = 0; i< length; i++){
	    result += current.getValue();
	    if(i != length - 1){
		result += ",";
	    }
	    current = current.getNext();
	}
	result += "]";
	return result;
    }

    public void clear(){
	length = 0;
	first = null;
	last = null;
    }
    
    public int size(){
	return length;
    }

    public T get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();
    }

    public T set(int index, T value){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
        Node target = getNode(index);
        T oldValue = target.getValue();
	target.setValue(value);
	return oldValue;
    }

    public int indexOf(T value){
	Node current = first;
	for(int i = 0; i < size(); i++){
	    if(current.getValue().equals(value)){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    public boolean add(T newData){
	Node data = new Node(newData);
	if(length == 0){
	    first = data;
	    last = first;
	}
	else {
	    last.setNext(data);
	    data.setPrev(last);
	    last = data;
	}
	length++;
	return true;
    }

    public void add(int index,T value){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	if(index == length){
	    add(value);
	}
	else if(index == 0){
	    Node data = new Node(value);
	    data.setNext(first);
	    first.setPrev(data);
	    first = data;
	    length++;
	}else{
	    Node data = new Node(value);
	    Node next = getNode(index);
	    Node prev = getNode(index-1);
	    data.setNext(next);
	    data.setPrev(prev);
	    next.setPrev(data);
	    prev.setNext(data);
	    length++;
	}
    }

    public boolean remove(T value){
	Node current = first;
	for (int i = 0; i < length; i++){
	    if(current.getValue().equals(value)){
		remove(i);
		return true;
	    }
	    current = current.getNext();
	}	
	return false;
    }


    public T remove(int index){
	if(index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();      
	}
	Node target = getNode(index);
	T oldValue = target.getValue();
	if(length == 1){
	    first = null;
	    last = null;
	}else if(index == 0){
	    first = first.getNext();
	    first.setPrev(null);
	}

	else if (index == length - 1){
	    last = getNode(index - 1);
	    last.setNext(null);
	}
	else{
	    Node prev = getNode(index - 1);
	    Node next = getNode(index + 1);
	    prev.setNext(next);
	    next.setPrev(prev);
	}
	length--;
	return oldValue;
    }
    
    /////////////////////////
    ///       Node        ///
    ////////////////////////

		
    private class Node{
	private Node next, prev;
	private T data;

	public Node(T data){
	    this.data = data;
	    prev = null;
	    next = null;
	}
    
	public T getValue(){
	    return data;
	}

	public void setValue(T newValue){
	    this.data = newValue;
	}
	
	public Node getPrev(){
	    return prev;
	}

	public void setPrev(Node newValue){
	    prev = newValue; 
	}

	public Node getNext(){
	    return next;
	}

	public void setNext(Node newValue){
	    next = newValue;
	}

	public String toString(){
	    return "" + data;
	}
    }

    ////////////
    //Iterator//
    ////////////


    private class ListIterator implements Iterator <T>{
	private Node current;

	public ListIterator(Node first){
	    current = first;
	}

	public boolean hasNext(){
	    return !(nextNode == null);
	}

	public T next(){
	    T result = current.getValue;
	    current = current.getNext();
	    return result;
	}
    }
    ////////
    //Main//
    ////////


}
