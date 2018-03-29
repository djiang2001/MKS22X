public class MyLinkedList{
    private Node first, last;
    private int length;
    public MyLinkedList(){
	first = new Node(0);
	next = new Node(0);
	length = 0;
    }

    public void clear(){
	first.setValue(0);
	first.setNext(0)
	last = first;
	last.setPrev(0);
    }
    
    public int size(){
	return length;
    }

    private Node getNode(int index){
	Node current = first;
	for(int i = index; i >= 0; i--){
	    current = Node.getNext();
	}
	return current;
    }

    public String toString(){
	String result = "";
	for(int i = 0; i< length - 1; i++){
	    result += getNode(i);
	}
	return result;
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

    public static void main(String[]args){
	MyLinkedList test = new MyLinkedList();
	test.add(1);
	test.add(2);
	System.out.println(test);
    }
}
