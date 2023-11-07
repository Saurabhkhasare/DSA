package Assignment6;


import java.util.Scanner;

public class DoublyLinkedList {
	static class Node {
		private int data;
		private Node next;
		private Node prev;

		public Node() {
			data = 0;
			prev = null;
			next = null;
		}

		public Node(int value) {
			data = value;
			prev = null;
			next = null;
		}
	}

	private Node head;
	private int count;
	public DoublyLinkedList() {
		head = null;
		count=0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoublyLinkedList list = new DoublyLinkedList();
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
					System.out.println("Display in forward manner");
					list.displayForward();
					System.out.println("Display in forward reverse");
					list.displayReverse();
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
	 boolean isEmpty() {
			return head==null;
		}
	void addfirst(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		count++;
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null)
			head = newNode;
		else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
			newNode.prev = trav;
		}
		count++;
	}

	void addAtSpecificPos(int pos, int value) {
		Node newNode = new Node(value);
		if (head == null||pos==1)
			addfirst(value);
		else {
			Node trav = head;
			Node temp = null;
			for (int i = 1; i < pos; i++) {
				if(trav.next==null)
					break;
				temp = trav;
				trav = trav.next;
			}
			if(trav.next==null) {
				trav.next=newNode;
				newNode.prev=trav;
			}
			else if(temp!=null) {
				newNode.prev=temp;
				temp.next=newNode;
				newNode.next=trav;
				trav.prev=newNode;
			}
			count++;
		}

	}
	void displayForward() {
		if (head == null)
			throw new RuntimeException("List is empty!!!");
		Node trav = head;
		do {
			System.out.println(trav.data);
			trav = trav.next;
		} while (trav != null);
	}

	void displayReverse() {
		if (head == null)
			throw new RuntimeException("List is empty!!!");
		Node trav = head;
		while (trav.next != null) {
			trav = trav.next;
		}
		do {
			System.out.println(trav.data);
			trav = trav.prev;
		} while (trav != null);
	}
}
