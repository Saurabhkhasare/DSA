package DoublyLinkedList;

import java.util.Scanner;

class DoublyLinkedList {

	static class Node {

		private int data;
		private Node next;
		private Node prev;

		public Node() {
			data = 0;
			next = null;
			prev = null;
		}

		public Node(int val) {
			data = val;
			next = null;
			prev = null;
		}

	}

	private Node head;

	public DoublyLinkedList() {
		head = null;
	}

	public void ForwardDisplay() {
		System.out.println("Forward List :");
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}

	public void ReverseDisplay() {
		System.out.println("Reverse List :");
		if (head == null) {
			return;
		}
		Node trav = head;
		while (trav.next != null) {
			trav = trav.next;
		}
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.prev;
		}

	}

	public void addFirst(int val) {

		Node newnode = new Node(val);

		if (head == null) {
			head = newnode;
		} else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
	}

	public void addLast(int val1) {

		Node newnode = new Node(val1);

		if (head == null) {
			head = newnode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newnode;
			newnode.prev = trav;
		}

	}

	public void addAtPos(int pos, int val2) {
		if (head == null || pos <= 1) {
			addFirst(val2);
		} else {
			Node newNode = new Node(val2);
			Node trav = head, temp;

			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null) {
					break;
				}
				trav = trav.next;
			}

			temp = trav.next;

			newNode.next = trav.next;
			newNode.prev = trav;
			trav.next = newNode;

			if (temp != null) {
				temp.prev = newNode;
			}
		}
	}

	public void deletefirst() {
		if (head == null) {
			throw new RuntimeException("list is empty");
		}
		if (head.next == null) {
			head = null;
		} else {
			Node trav = head;
			head = trav.next;
			head.prev = null;
		}

	}

	public void deleteLast() {
		if (head == null) {
			throw new RuntimeException("list is empty");
		}
		if (head.next == null) {
			head = null;
		} else {
			Node trav = head, temp = null;
			while (trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			temp.next = null;
		
		}
	}

	public void deleteAtPos(int pos) {
		if (pos == 1) {
			return;
		}
		if (head == null || pos < 1) {
			throw new RuntimeException("list is empty");
		} else {
			Node trav = head;
			for (int i = 1; i < pos; i++) {
				if (trav == null) {
					break;
				}
				trav = trav.next;
			}
			trav.prev.next = trav.next;
			if (trav.next != null) {
				trav.next.prev = trav.prev;
			}
		}
	}

	public void deleteAll() {
		head.next = null;
		head = null;

	}

}

public class DoublyLinkedListMain {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			DoublyLinkedList list = new DoublyLinkedList();
			boolean exit = false;

			while (!exit) {
				System.out.println("1.Display \r\n" + "2.addfirst \r\n" + "3.addlast  \r\n" + "4.addAtpos  \r\n"
						+ "5.deletefirst  \r\n" + "6.deletelast  \r\n" + "7.deleteAtPos  \r\n" + "8.deleteAll");
				System.out.println("Enter the choice");

				try {

					switch (sc.nextInt()) {
					case 1:
						list.ForwardDisplay();
						list.ReverseDisplay();
						break;

					case 2:
						System.out.print("Enter the value:");
						int val = sc.nextInt();
						list.addFirst(val);
						break;

					case 3:
						System.out.print("Enter the value:");
						int val1 = sc.nextInt();
						list.addLast(val1);

						break;

					case 4:
						System.out.print("Enter the position:");
						int pos = sc.nextInt();
						System.out.print("Enter the value:");
						int val2 = sc.nextInt();
						list.addAtPos(pos, val2);
						break;

					case 5:
						list.deletefirst();
						break;

					case 6:
						list.deleteLast();
						break;

					case 7:
						System.out.println("Enter the position:");
						pos = sc.nextInt();
						list.deleteAtPos(pos);
						break;

					case 8:
						list.deleteAll();
						break;

					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}

}
