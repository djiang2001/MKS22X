public class MyLinkedList{
    private Node first, last;
    private int length;

    //Important Method
    private Node getNode(int index){
	Node current = first;
	for(int i = 0; i < length; i++){
	    current = current.getNext();
	}
	return current;
    }

    //Constructor
    public MyLinkedList(){
	length = 0;
    }

    public String toString(){
	String result = "";
	for(int i = 0; i< length - 1; i++){
	    result += getNode(i).getValue();
	}
	return result;
    }

    public void clear(){
	length = 0;
	first 
    }
    
    public int size(){
	return length;
    }

    public Integer get(int index){


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
    
	public int getValue(){
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
	MyLinkedList test = new MyLinkedList();
	test.add(1);
	test.add(2);
	System.out.println(test);
    }
    
}
