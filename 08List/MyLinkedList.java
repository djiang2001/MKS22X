public class MyLinkedList{
    private Node first, last;
    private int length;

    //Important Method
    private Node getNode(int index){
	Node current = first;
	if(index == length - 1){
	    return last;
	}
	for(int i = index; i > 0; i--){
	    current = current.getNext();
	}
	return current;
    }

    //Constructor
    public MyLinkedList(){
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

    public Integer get(int index){
	if(index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();
    }

    public Integer set(int index, Integer value){
	if(index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
        Node target = getNode(index);
        Integer oldValue = target.getValue();
	target.setValue(value);
	return oldValue;
    }

    public int indexOf(Integer value){
	Node current = first;
	for(int i = 0; i < length; i++){
	    if(current.getValue().equals(value)){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    public boolean add(Integer newData){
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

    public void add(int index,Integer value){
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
	}
	length++;
    }

    public boolean remove(Integer value){
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

    public Integer remove(int index){
	if(index > length || index < 0){
	    throw new IndexOutOfBoundsException();      
	}
	Node target = getNode(index);
	Integer oldValue = target.getValue();
	if (index == 0){
	    first = first.getNext();
	    first.setPrev(null);
	}

	else if (index == length -1){
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
	private Integer data;

	public Node(Integer data){
	    this.data = data;
	}
    
	public Integer getValue(){
	    return data;
	}

	public void setValue(int newValue){
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
    
    ////////
    //Main//
    ////////

	    
    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	
	System.out.println(list);
	list.add(0);
	list.add(10);
	list.add(20);
	list.set(1, 15);
	list.add(1,10000000);

	list.remove(1);
	System.out.println("the index of 10 is: " + list.indexOf(10));
	System.out.println("length: " + list.size());
	System.out.println(list);
	list.clear();
	
	System.out.println(list.get(0));
	System.out.println(list.size());
    }
    
}
