package Assignment4;



public class CircularQueueCore {
	private int maxSize;
	private int[] queueArray;
	private int front;
	private int rear;
	private int nItems;

	public CircularQueueCore(int size) {
		maxSize = size;
		queueArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void enqueue(int value) {
		if (!isFull()) {
			if (rear == maxSize - 1) {
				rear = -1;
			}
			queueArray[++rear] = value;
			nItems++;
			System.out.println("Enqueued " + value + " into the circular queue.");
		} else {
			System.out.println("Circular Queue is full. Cannot enqueue " + value);
		}
	}

	public int dequeue() {
		if (!isEmpty()) {
			int temp = queueArray[front++];
			if (front == maxSize) {
				front = 0;
			}
			nItems--;
			System.out.println("Dequeued " + temp + " from the circular queue.");
			return temp;
		} else {
			System.out.println("Circular Queue is empty. Cannot dequeue.");
			return -1;
		}
	}

	public void display() {
		if (!isEmpty()) {
			System.out.println("Circular Queue elements are:");
			if (rear >= front) {
				for (int i = front; i <= rear; i++) {
					System.out.println(queueArray[i]);
				}
			} else {
				for (int i = front; i < maxSize; i++) {
					System.out.println(queueArray[i]);
				}
				for (int i = 0; i <= rear; i++) {
					System.out.println(queueArray[i]);
				}
			}
		} else {
			System.out.println("Circular Queue is empty.");
		}
	}

	
	public int size() {
		return nItems;
	}

	public boolean isFull() {
		return nItems == maxSize;
	}

	public boolean isEmpty() {
		return nItems == 0;
	}
}
