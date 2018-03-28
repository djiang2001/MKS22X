public class MyLinkedList{
    private Node first, last;
    private int length;
    public MyLinkedList(){
	first = new Node(0);
	next = new Node(0);
	length = 0;
    }

    private class Node{
	private Node next, prev;
	private int data;

	public Node(int data){
	    this.data = data;
	}
    
	public int getValue(){
	    return data;
	}

	public void setValue(int newValue){
	    this.data = newValue;
	}
	
	public int getPrev(){
	    return prev;
	}

	public void setPrev(int newValue){
	    prev.setValue(newValue); 
	}

	public int getNext(){
	    return next;
	}

	public void setNext(int newValue){
	    next.setValue(newValue);
	}

	public String toString(){
	    return "" + this.getValue;
	}
    }
}
