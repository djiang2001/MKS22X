import java.util.*;

public class Calculator{
    public static double eval(String s){
	Stack stack = new Stack();
	String operator = "+-*/%";
	String[] holder = s.split(" ");
	for(int i = 0; i < holder.length; i++){
	    if(!operator.contains(holder[i])){
		stack.push(Double.parseDouble(holder[i]));
	    } else{
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
		    double last = stack.pop();
		    double first = stack.pop();
		    stack.push(first % last);
		}
	    }
	}
	return stack.pop();
    }
    /*
    public static void main(String[] args){
	System.out.println(Calculator.eval("10 -2.0 +"));
	System.out.println(Calculator.eval("11 3 - 4 + 2.5 *"));
	System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));
	System.out.println(Calculator.eval("10 2.0 /"));
	System.out.println(Calculator.eval("10 2.0 %"));
    }
    */
}
