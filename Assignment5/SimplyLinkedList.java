package Assignment5;

import java.util.Scanner;

public class SimplyLinkedList {
	static class Node {

		private int data;
		private Node next;

		public Node() {
			super();
			this.data = 0;
			this.next = null;
		}

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private int count;

	public SimplyLinkedList() {
		head = null;
		count = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimplyLinkedList list = new SimplyLinkedList();
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("Menu\n" + "1.Displaying all elements\n" + "2.Add node at first position\n"
						+ "3.Add node at last position\n" + "4.Add node at specific position\n"
						+ "5.Total number of elements\n"
						+ "6.Check to see if list is empty"
						+ "0.EXIT");
				System.out.println("Enter your choice");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Display");
					list.display();

					break;
				case 2:
					System.out.println("enter new element");
					int element = sc.nextInt();
					list.addFirst(element);
					break;

				case 3:
					System.out.println("enter new element");
					element = sc.nextInt();
					list.addLast(element);
					break;
				case 4:
					System.out.println("enter position and element-");
					list.addAtSpecificPos(sc.nextInt(), sc.nextInt());
					break;
				case 5:
					System.out.println("Total number of elements are: " + list.count);
					break;
				case 6:
					System.out.println(list.isEmpty());
					break;
				case 0:
					exit = true;
					System.out.println("Thanks,Exiting!!");
					break;
				default:
					System.out.println("invaid choice");
					break;

				}
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
				System.out.println("Please try again!!");
			}
		}
		sc.close();
	}

	private boolean isEmpty() {
		return (head==null);
	}

	void display() {
		if (isEmpty())
			System.out.println("list is empty");
		else {
			Node trav = head;
			while (trav != null) {
				System.out.print(trav.data + " -> ");
				trav = trav.next;
			}
			System.out.println();
		}
	}

	public void addFirst(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		count++;
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		if (isEmpty())
			head = newNode;
		else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
		}
		count++;
	}

	public void addAtSpecificPos(int pos, int value) {
		// case1: if list is empty
		if (isEmpty() || pos <= 1)
			addFirst(value);
		else {
			// case2: general case
			Node newNode = new Node(value);
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				// case3: if position> length of linked list: then add in last
				if (trav.next == null) {
					trav.next = newNode;
					break;
				}
				trav = trav.next;
			}
			newNode.next = trav;
			trav.next = newNode;
		}
		count++;
	}
}
