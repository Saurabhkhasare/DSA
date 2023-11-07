package Stack;

import java.util.Stack;

public class InfixPrefixMain {
	private static int calc(int a, int b, int operator) {
		switch (operator) {
		case '$':
			return (int) Math.pow(a, b);
		case '*':
			return a * b;
		case '/':
			return a / b;
		case '%':
			return a % b;
		case '+':
			return a + b;
		case '-':
			return a - b;

		}
		return 0;
	}

	private static int solvetoprefix(String prefix) {
		// stack of operand
		Stack<Integer> s = new Stack<>();
		// travere prefic from right to left
		for (int i = prefix.length() - 1; i >= 0; i--) {
			//get each symbol from expression
			char symbol = prefix.charAt(i);
			//if sys(symbol) is operand
			if (Character.isDigit(symbol)) {
				//convert it to int push on stack
				// eg. '5' ki asci value -toString()->"5" ki then usko -parseInt()->5 integer me kiya
				String operand = Character.toString(symbol);
				s.push(Integer.parseInt(operand));
			} else {
				//pop two operands from stack
				int a = s.pop();
				int b = s.pop();
				//push result on stack
				int c = calc(a, b, symbol);
				s.push(c);
			}
		}//repeat  for all syms in expression
		//pop final result from stack and return.
		return s.pop();
	}

	private static int prim(Character operator) {
		switch (operator) {
		case '$':
			return 10;// becoz it has higher priority that's y we wrote 10
		case '*':
			return 7;
		case '/':
			return 7;
		case '%':
			return 7;
		case '+':
			return 3;
		case '-':
			return 3;
		}
		return 0;
	}

	public static String infixToPrefix(String infix) {
		Stack<Character> s = new Stack<>();
		StringBuilder pre = new StringBuilder();//it is use for append and stringbuilder use for single threaded environment so it is prefer
		//1.traverse infix expression from  right to left

		for (int i = infix.length() - 1; i >= 0; i--) {
			char sym = infix.charAt(i);//sym can be "(" ,")" or operator
			//2.if operand is found,append to postfix

			if (Character.isDigit(sym)) {
				pre.append(sym);
			} else if (sym == ')') {//4.if opening  ")" is pound then push it on stack
				s.push(sym);
			} else if (sym == '(') {// 5> if opening "(" is found,
				
				//pop all operators from stack one by one and append to postfix
				//untill opening "(" is found
				while (s.peek() != ')') {
					pre.append(s.pop());
				}
				//also pop and discard closing ")"
				s.pop();

			} else {
				//3.if "operator" is found,push it on the stack
				
				//if priority of topmost operator from stack > priority of current operator,we use repatedly
				while (!s.isEmpty() && prim(s.peek()) > prim(sym)) {
					//pop operator from stack and append to postfix
					pre.append(s.pop());
				}
				s.push(sym);
			}
		}//end of for loop
		
		//6. when all syms from infix are done,pop all operators from stack one by one and append to postfix
		while (!s.isEmpty()) {
			pre.append(s.pop());
		}

		return pre.reverse().toString();

	}

	public static void main(String[] args) {

		String infix = "5+9-4*(8-6/2)+1$(7-3)";
		String prefix = "";
		prefix = infixToPrefix(infix);
		System.out.println("prefix: " + prefix);
		int result = solvetoprefix(prefix);
		System.out.println("Result : " + result);

	}

}
