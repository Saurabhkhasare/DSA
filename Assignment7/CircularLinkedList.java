package Assignment7;


import java.util.Scanner;

public class CircularLinkedList {
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

	public CircularLinkedList() {
		head = null;
		count = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularLinkedList list = new CircularLinkedList();
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
					list.addfirst(element);
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
	void display() {
		if (head == null) {
			System.out.println("list is empty");
			return;
		} else {
			Node trav = head;
			do {
				System.out.println(trav.data);
				trav = trav.next;
			} while (trav != head);
		}
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			Node trav = head;
			while (trav.next != head) {
				trav = trav.next;
			}
			newNode.next = head;
			trav.next = newNode;
		}
		count++;
	}

	void addfirst(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			Node trav = head;
			while (trav.next != head) {
				trav = trav.next;
			}
			trav.next = newNode;
			newNode.next = head;
			head = newNode;
		}
		count++;
	}

	void addAtSpecificPos(int pos, int value) {
		//CASE1: if position is given 1 that means add at first pos
		if (pos == 1)
			addfirst(value);
		else {
			Node newNode = new Node(value);
			Node trav = head;
			for (int i = 1; i < pos-1; i++) {
				//CASE2: if position is given out of index then adding at last
				if (trav.next == head) {
					newNode.next = head;
					trav.next = newNode;
					break;
				}
				trav = trav.next;
			}
			if(newNode.next!=head) {
				// adding at specific condition
				newNode.next = trav.next;
				trav.next = newNode;
			}
		count++;	
		}
	}
	private boolean isEmpty() {
		return (head==null);
	}
}