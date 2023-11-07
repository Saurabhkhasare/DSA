package Stack;

import java.util.Scanner;

class Stack {
	// if we here use object[] type of array you can store any type of data
	private int[] arr;
	private int top;

	public Stack(int size) {
		arr = new int[size];
		top = -1;
	}

	public void push(int val) {
		//
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}
		top++;
		arr[top] = val;
	}

	public void pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		top--;
	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return arr[top];
	}

	public boolean isEmpty() {
		return top == -1;// when condition is true return true otherwise false
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
		} else {
			System.out.print("Stack: ");
			for (int i = 0; i <= top; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

}

public class StackMian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack(6);
		boolean exit = false;
		while (!exit) {
			System.out.println("\n0. Exit\n1. Push\n2. Pop\n3. Peek\n4. Empty\n5. Full\n6. Display\nEnter choice: ");

			switch (sc.nextInt()) {
			case 1:
				try {
					System.out.println("Enter the value:");
					int val = sc.nextInt();
					s.push(val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					// here we see which element should pop
					int val = s.peek();
					// here we popped that element
					s.pop();
					// here we print that pooped element
					System.out.println("Popped: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					// here we see which element should pop
					int val = s.peek();
					System.out.println("Peeked: " + val);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					  System.out.println("Stack is Empty: " + s.isEmpty());

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				try {
					  System.out.println("Stack is Full: " + s.isFull());

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				s.display();
				break;
			case 0:
				exit = true;
				break;
			}
		}
	}
}
