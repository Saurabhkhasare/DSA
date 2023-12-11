package question5;

public class CircularaQueueImpl implements ICircularQueue {

	private int sizeOfQueue;
	private String[] myQueue;
	private int front;
	private int rear;

	public CircularaQueueImpl(int capacity) {
		myQueue = new String[capacity];
		this.front = 0;
		this.rear = 0;
		this.sizeOfQueue = 0;
	}

	private boolean isFull() {
		return sizeOfQueue == myQueue.length/* (myQueue.length==rear)&&(front==0) */;
	}

	private boolean isEmpty() {
		return sizeOfQueue == 0;
	}

	@Override
	public boolean add(String element) {
		if (isFull()) {
			return false;
		} else {
			myQueue[rear] = element;
			rear = (rear + 1) % myQueue.length;
			sizeOfQueue++;
			return true;
		}
	}

	@Override
	public String remove() {
		if (isEmpty())
			return null;
		else {
			String element = "Element is removed " + myQueue[front];
			front = (front + 1) % myQueue.length;
			sizeOfQueue--;
			return element;
		}
	}

	@Override
	public int size() {
		return sizeOfQueue;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return " ";
		else {
			StringBuilder sb = new StringBuilder();
//			int index = front;
			for (String s : myQueue) {
				sb.append(s).append(", ");
			}
			sb.setLength(sb.length() - 2);
			return sb.toString();
		}

	}

	public static void main(String[] args) {
		ICircularQueue circularQueue = new CircularaQueueImpl(5);

        // Add elements to the queue
        System.out.println("Adding elements to the queue:");
        System.out.println("Add A: " + circularQueue.add("A"));
        System.out.println("Add B: " + circularQueue.add("B"));
        System.out.println("Add C: " + circularQueue.add("C"));
        System.out.println("Add D: " + circularQueue.add("D"));
        System.out.println("Add E: " + circularQueue.add("E"));
        System.out.println("Add F: " + circularQueue.add("F")); // Queue is full, returns false

        // Display the queue
        System.out.println("\nQueue elements:");
        System.out.println("toString: " + circularQueue.toString());

        // Remove elements from the queue
        System.out.println("\nRemoving elements from the queue:");
        System.out.println("Remove: " + circularQueue.remove());
        System.out.println("Remove: " + circularQueue.remove());
        System.out.println("Remove: " + circularQueue.remove());
        System.out.println("Remove: " + circularQueue.remove());
        System.out.println("Remove: " + circularQueue.remove());
        System.out.println("Remove: " + circularQueue.remove()); // Queue is empty, returns null

        // Display the queue size after removals
        System.out.println("\nQueue size after removals: " + circularQueue.size());
	}

}
