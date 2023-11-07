package SinglyLinkedList;

import java.util.Scanner;

class SinglyList {

	static class Node {

		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int value) {
			data = value;
			next = null;
		}
	}

	// list class fields
	private Node head;

	// Singlylist class constructor
	public SinglyList() {
		head = null;
	}

	void Display() {
		System.out.println("List :");
		Node trav = head;
		while (trav != null) {

			System.out.println(trav.data);
			trav = trav.next;
		}
		System.out.println("list is empty");

	}

	void addfirst(int val) {
		// create newnode and initilize it
		Node newNode = new Node(val);
		// newNode next should point to head

		newNode.next = head;
		// head should point to newnode
		head = newNode;
	}

	void addlast(int val) {

		Node newNode = new Node(val);
		// if list is empty make new node as first node of list;
		if (head == null) {
			head = newNode;
		} else {
			// traverse till last node
			Node trav = head;
			while (trav.next != null) {

				trav = trav.next;
			}
			// add new node after trav(trav.next)
			trav.next = newNode;

		}

	}

	public void addAtPos(int val1, int pos) {

		if (head == null || pos <= 1) {
			addfirst(val1);
		} else {

			Node newNode = new Node(val1);
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null) {
					break;
				}
				trav = trav.next;
				newNode.next = trav.next;
				trav.next = newNode;
			}
		}
	}

	public void deleteFirst() {

		if (head == null) {
			throw new RuntimeException("List is Empty");
		}
		Node trav = head; // or direct { head = head.next }
		head = trav.next;

	}

	public void deletelast() {

		if (head == null) {
			throw new RuntimeException("List Empty");
		}

		if (head.next == null) {
			head = null;
		} else {
			Node trav = head;
			Node temp = null;

			while (trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			temp.next = null;
		}
	}

	public void deleteAtPos(int pos1) {

		if (pos1 == 1) {
			deleteFirst();
		}

		if (head == null || pos1 < 1) {
			throw new RuntimeException("list is empty or invalid position");
		}

		Node temp = null;
		Node trav = head;

		for (int i = 1; i < pos1; i++) {
			if (trav == null) {
				throw new RuntimeException("invalid position");
			}

			temp = trav;
			trav = trav.next;

		}
		temp.next = trav.next;

	}

	public void deletAll() {
		head = null;

	}

}

public class SinglyListMain {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			SinglyList list = new SinglyList();
			boolean exit = false;
			while (!exit) {

				System.out.println("1.Display \r\n" + "2.addfirst \r\n" + "3.addlast  \r\n" + "4.addAtpos  \r\n"
						+ "5.deletefirst  \r\n" + "6.deletelast  \r\n" + "7.deleteAtPos  \r\n" + "8.deleteAll");
				System.out.println("Enter the choice");

				try {
					switch (sc.nextInt()) {
					case 1:
						list.Display();

						break;
					case 2:
						System.out.println("Enter the value :");
						int val = sc.nextInt();
						list.addfirst(val);

						break;

					case 3:
						System.out.println("Enter the value :");
						val = sc.nextInt();
						list.addlast(val);

						break;

					case 4:
						System.out.println("Enter the value:");
						int val1 = sc.nextInt();
						System.out.println("Enter the position:");
						int pos = sc.nextInt();

						list.addAtPos(val1, pos);

						break;

					case 5:// try catch use if your list is empty then also u are deleting elements then it
							// give NullPointer exception
						try {
							list.deleteFirst();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

						break;

					case 6:
						try {
							list.deletelast();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						break;

					case 7:
						System.out.print("Enter the position:");
						int pos1 = sc.nextInt();
						try {
							list.deleteAtPos(pos1);
						} catch (Exception e) {
						System.out.println(e.getMessage());
						}
						
						break;

					case 8:
						list.deletAll();
						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
