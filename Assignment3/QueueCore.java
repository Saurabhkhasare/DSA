package Assignment3;

public class QueueCore {
		private int maxSize;
		private int[] queueArray;
		private int front;
		private int rear;
		private int numItems;

		public QueueCore(int size) {
			maxSize = size;
			queueArray = new int[maxSize];
			front = 0;
			rear = -1;
			numItems = 0;
		}

		public void insert(int value) {
			if (rear == maxSize - 1) {
				System.out.println("Queue is full. Cannot insert " + value);
			} else {
				queueArray[++rear] = value;
				numItems++;
				System.out.println("Inserted " + value + " into the queue.");
			}
		}

		public void remove() {
			if (numItems == 0) {
				System.out.println("Queue is empty. Cannot remove.");
			} else {
				int value = queueArray[front++];
				numItems--;
				System.out.println("Removed " + value + " from the queue.");
			}
		}

		public void display() {
			if (numItems == 0) {
				System.out.println("Queue is empty.");
			} else {
				System.out.println("Queue elements are:");
				for (int i = front; i <= rear; i++) {
					System.out.println(queueArray[i]);
				}
			}
		}

		public int size() {
			return numItems;
		}

		public boolean isFull() {
			return numItems == maxSize;
		}

		public boolean isEmpty() {
			return numItems == 0;
		}
}
