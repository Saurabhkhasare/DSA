package Assignment4;


import java.util.Scanner;

public class CircularQueueOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		System.out.print("Enter the size of the circular queue: ");
		int size = sc.nextInt();

		CircularQueueCore circularQueue = new CircularQueueCore(size);

		while (!exit) {
			try {
				System.out.println("\nSelect an operation:");
				System.out.println("1. Display the circular queue");
				System.out.println("2. Enqueue data into the circular queue");
				System.out.println("3. Dequeue data from the circular queue");
				System.out.println("4. Check how many elements are there in the circular queue");
				System.out.println("5. Check if the circular queue is full");
				System.out.println("6. Check if the circular queue is empty");
				System.out.println("7. Exit");

				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					circularQueue.display();
					break;
				case 2:
					System.out.print("Enter the value to enqueue: ");
					int value = sc.nextInt();
					circularQueue.enqueue(value);
					break;
				case 3:
					circularQueue.dequeue();
					break;
				case 4:
					System.out.println("Number of elements in the circular queue: " + circularQueue.size());
					break;
				case 5:
					System.out.println("Is the circular queue full? " + circularQueue.isFull());
					break;
				case 6:
					System.out.println("Is the circular queue empty? " + circularQueue.isEmpty());
					break;
				case 7:
					exit = true;
					System.out.println("Thanks,Exiting!!!");
					break;
				default:
					System.out.println("Invalid choice!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
				System.out.println("Please try again!!");
			}

		}
		sc.close();
	}

}
