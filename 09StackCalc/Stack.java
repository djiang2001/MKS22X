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
	int index = list.size()-1;
	list.remove(index);
	return list.get(index);
    }

    public Double peek(){
	int top = list.size()-1;
	return list.get(top);
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
