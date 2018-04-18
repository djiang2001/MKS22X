import java.util.*;

public class Eval{
    public static double eval(String s){
	Stack stack = new Stack();
	String operator = "+-*/%";
	String[] holder = s.split(" ");
	for(int i = 0; i < holder.length; i++){
	    if(holder[i].equals("+")){
		stack.push(stack.pop() + stack.pop());
	    } 
	    if(holder[i].equals("-")){
		stack.push((stack.pop() * -1) + stack.pop());
	    }
	    if(holder[i].equals("*")){
		stack.push(stack.pop() * stack.pop());
	    }
	    if(holder[i].equals("/")){
		stack.push((1/stack.pop()) * stack.pop());
	    }
	    if(holder[i].equals("%")){
		stack.push()
	    }
	}
    }
}
