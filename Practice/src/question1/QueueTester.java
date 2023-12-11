package question1;

import java.util.Scanner;

public class QueueTester {
	    public static void main(String[] args) {
	        try (Scanner sc = new Scanner(System.in)) {
	            StackWithTwoQueues myStack = new StackWithTwoQueues();
	            boolean exit = false;

	            while (!exit) {
	                try {
	                    System.out.println("Choose an option :\n"
	                            + "1. Push\n"
	                            + "2. Pop\n"
	                            + "3. Find Top Element\n"
	                            + "4. Find Max Element\n"
	                            + "5. Find Min Element\n"
	                            + "0. Exit\n");

	                    switch (sc.nextInt()) {
	                        case 1:
	                            System.out.println("Enter the element to push:");
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
	                            exit = true;
	                            System.out.println("Bye!");
	                            break;
	                        default:
	                            System.out.println("Invalid option. Please try again.");
	                            break;
	                    }
	                } catch (Exception e) {
	                    System.out.println("Please try again!!!");
	                    sc.nextLine(); // Consume the newline character
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}


