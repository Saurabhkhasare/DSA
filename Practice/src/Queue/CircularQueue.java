package Queue;


import java.util.Scanner;

public class CircularQueue {

	private int arr[];
	private int rear;
	private int front;
	private int count;

	public CircularQueue(int size) {
		arr = new int[size];
		front = -1;
		rear = -1;
		count = 0;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			CircularQueue myQueue = new CircularQueue(5);
			while (!exit) {
				try {
					System.out.println("Enter a choice: \n" + "1.EnQueue an element\n" + "2.DeQueue an element\n"
							+ "3.Find First element\n" + "4.Check the Queue is empty or not\n"
							+ "5.Check the Queue is Full or not\n"
							+ "6.Find Last element\n"
							+ "7.Display the queue\n"
							+ "8.Count the elements in queue\n" + "0.Exit ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter an element: ");
							myQueue.enQueue(sc.nextInt());	
						break;
					case 2:
						myQueue.deQueue();
						break;
					case 3:
						System.out.println("First element is:- "+myQueue.peek());
						break;
					case 4:
						System.out.println(myQueue.isEmpty());
						break;
					case 5:
						System.out.println(myQueue.isFull());
						break;
					case 6:
						System.out.println("Last  element is:-"+myQueue.getRear());
						break;
					case 7:
						myQueue.display();
						break;
					case 8:
						System.out.println("Total elements are: "+myQueue.count);
						break;
					case 0:
						exit = true;
						System.out.println("Thanks,Exiting!!!!");
						break;
					default:
						System.out.println("Invalid choice!!!!");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
					System.out.println("Please try again!!!");
				}
			}
		}
	}

	private void display() {
		if(isEmpty())
			throw new RuntimeException("Queue is empty!!!");
		for(int i = front+1; i<=rear;i++)
			System.out.print(arr[i]+"->");
		System.out.println();
	}

	private int getRear() {
		if(isEmpty())
			throw new RuntimeException("Queue is empty!!!");
		return arr[rear];
	}

	private int peek() {
		if(isEmpty())
			throw new RuntimeException("Queue is empty!!!");
		int index = (front + 1 )% arr.length;
		return arr[index];
	}

	private void deQueue() {
		if(isEmpty())
			throw new RuntimeException("Queue is empty!!!");
		System.out.println("Popped " + arr[(front+1)%arr.length]);
		front = (front + 1)%arr.length;
		if(front==rear) {
			front= -1;
			rear = -1;
		}
		count--;
	}

	private void enQueue(int value) {
		if(isFull())
			throw new RuntimeException("Queue is Full");
		rear = (rear + 1)%arr.length;
		arr[rear] = value;
		count++;
	}

	private boolean isFull() {
		return (front == rear && front!=-1) || (front == -1 && rear == arr.length-1) ;
	}

	private boolean isEmpty() {
		return (front == rear && front==-1);
	}

}
