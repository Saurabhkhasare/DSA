package question1;

import java.util.Scanner;

public class StackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter the size of the array ");
			StackWithConstantTime myStack = new StackWithConstantTime(sc.nextInt());
			boolean exit = false;
			while(!exit){
				try {
					System.out.println("Choose an option :\n"
							+ "1.Push\n"
							+ "2.Pop\n"
							+ "3.Find top element\n"
							+ "4.Find Max Element\n"
							+ "5.Find Min Element\n"
							+ "0.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						myStack.push(sc.nextInt());
						break;
					case 2:
						myStack.pop();
						break;
					case 3:
						myStack.top();
						break;
					case 4:
						myStack.getMax();
						break;
					case 5:
						myStack.getMin();
						break;
					case 0:
						exit=true;
						System.out.println("byeee");
					default:
						break;
					}
				}catch(Exception e) {
					System.out.println("Please try again!!!");
					sc.nextLine();
					e.printStackTrace();
				}
			}
		}
	}

}
