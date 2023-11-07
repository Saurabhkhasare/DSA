package Stack;

import java.util.Stack;

public class InfixPostfixMain {

	//****************** code for stack operand infix to postfix*************///
	public static int cal(int a,int b,char operator)
	{
		switch (operator) {
		case '$': return (int) Math.pow(a, b);
		case '*':return a  * b;
		case '/':return a  / b;
		case '%':return a  % b;
		case '+':return a  + b;
		case '-':return a  - b;
		}
		return 0;
	}
	public static int solvePostfix(String post)
	{// stack of operand
		Stack<Integer> s = new Stack<>();
		// traverse postfix from left to right
		for (int i = 0; i < post.length(); i++) {
			//get each symbol from expression
			char sys = post.charAt(i);
			//if sys(symbol) is operand
			if(Character.isDigit(sys)) {
				//convert it to int push on stack
				// eg. '5' ki asci value -toString()->"5" ki then usko -parseInt()->5 integer me kiya
				String operand = Character.toString(sys);
				s.push(Integer.parseInt(operand));
			}
			else {
				//pop two operands from stack
				int b = s.pop();
				int a= s.pop(); 
				//push result on stack
				int c= cal(a, b, sys);
				s.push(c);
				 
			}
		}//repeat  for all syms in expression
		//pop final result from stack and return.
		return s.pop();
	}
	
	//****************** code for stack operator infix to postfix*************///
	public static int pri(char operator)
	{
		switch (operator) {
		case '$': return 10;//becoz it has higher priority that's y we wrote 10
		case '*': return 7;
		case '/': return 7;
		case '%': return 7;
		case '+': return 3;
		case '-': return 3;
		}
		return 0;
	}
	
	public static String infixToPostfix(String infix)
	{
		Stack<Character> s = new Stack<>();
		StringBuilder post = new StringBuilder();//it is use for append and stringbuilder use for single threaded environment so it is prefer
		//1.traverse infix expression from left to right
		for (int i = 0; i < infix.length(); i++) 
		{
			char sym = infix.charAt(i);//sym can be "(" ,")" or operator
			//2.if operand is found,append to postfix
			if(Character.isDigit(sym))
			{
				post.append(sym);
			}else if(sym == '(') //4.if opening  "(" is pound then push it on stack
				{
					s.push(sym);
				}
			else if(sym== ')') // 5> if closing ")" is found,
				{
					//pop all operators from stack one by one and append to postfix
					//untill opening "(" is found
					while(s.peek() != '(' )
					{
						post.append(s.pop());
					}
					//also pop and discard opening "("
					s.pop();
				}
				else {
					//3.if "operator" is found,push it on the stack
				
						//if priority of topmost operator from stack >= priority of current operator,we use repatedly
						while(!s.isEmpty() &&  pri(s.peek()) >= pri(sym))
						{
						//pop operator from stack and append to postfix
							post.append(s.pop());
					}
						s.push(sym);
					}
				}//end of for loop
			
			//6. when all syms from infix are done,pop all operators from stack one by one and append to postfix
			while(!s.isEmpty()) {
				post.append(s.pop());	
			}
			return post.toString();
		}
	
	
	public static void main(String[] args) {
		String infix = "5+9-4*(8-6/2)+1$(7-3)";
		String postfix="";
		postfix= infixToPostfix(infix);
		System.out.println("postfix:" +postfix);
		int result = solvePostfix(postfix);
		System.out.println("Result : "+ result );
		
		
		
		
		 
	}

}
