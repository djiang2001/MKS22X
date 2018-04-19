import java.util.*;

public class Stack{
    public LinkedList<Double> list;

    @SuppressWarnings("unchecked")
    public Stack(){
	list = new LinkedList();
    }

    public void push(Double item){
	list.add(item);
    }

    public Double pop(){
	Double index = list.getLast();
	list.removeLast();
	return index;
    }

    public Double peek(){
	return list.getLast();
    }

    public String toString(){
	String result = "";
	for(Double item: list){
	    result += item + " ";
	}
	return result;
    }

    /*
    public static void main(String[]args){
	Stack test = new Stack();
	test.push(1.0);
	test.push(2.0);
	System.out.println(test.peek());
    }
    */
}
