package Assignment3;


import java.util.Scanner;

public class QueueOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		System.out.print("Enter the size of the queue: ");
		int size = sc.nextInt();

		QueueCore queue = new QueueCore(size);

		while (!exit) {
			try {
				System.out.println("\nSelect an operation:");
				System.out.println("1. Display the queue");
				System.out.println("2. Insert data into the queue");
				System.out.println("3. Remove data from the queue");
				System.out.println("4. Check how many elements are there in the queue");
				System.out.println("5. Check if the queue is full");
				System.out.println("6. Check if the queue is empty");
				System.out.println("7. Exit");

				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					queue.display();
					break;
				case 2:
					System.out.print("Enter the value to insert: ");
					int value = sc.nextInt();
					queue.insert(value);
					break;
				case 3:
					queue.remove();
					break;
				case 4:
					System.out.println("Number of elements in the queue: " + queue.size());
					break;
				case 5:
					System.out.println("Is the queue full? " + queue.isFull());
					break;
				case 6:
					System.out.println("Is the queue empty? " + queue.isEmpty());
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
				System.out.println("Please try again!!!");
			}
		}
		sc.close();
	}
}
