package question4;

import java.util.Scanner;

public class CustomSinglyLinkedList {

	class Node {
		private int data;
		private Node next;

		Node() {
			this.data = 0;
			this.next = null;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	public CustomSinglyLinkedList() {
		head = null;
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			// D.S
			CustomSinglyLinkedList list = new CustomSinglyLinkedList();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Choose :\n" + "1.Add element at end\n" + "2.Find element X \n" + "3.ToString \n"
							+ "4.To check list is Sorted(in Ascending Order) \n" + "0.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter a value: ");
						System.out.println(list.addEnd(sc.nextInt()));
						break;
					case 2:
						System.out.println("Enter a element : ");
						System.out.println(list.find(sc.nextInt()));
						break;
					case 3:
						list.toString();
						break;
					case 4:
						System.out.println(list.isSorted()); 
						break;
					case 0:
						exit = true;
						System.out.println("byeeee");
						break;

					default:
						break;
					}
				} catch (Exception e) {
					System.out.println("PLease try again!!!");
					sc.nextLine();
					e.printStackTrace();
				}
			}

		}

	}

	private boolean isSorted() {
		Node trav = head;
		Node temp = null;
		while(trav!=null) {
			temp = trav;
			trav = trav.next;
			if(trav!=null&&temp.data>trav.data)
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		Node trav = head;
		while(trav!=null) {
			System.out.print(trav.data+", ");
			trav = trav.next;
		}
		System.out.println("");
		return "";
	}

	private int find(int val) {

		Node trav = head;
		for (int i = 1; trav != null; i++) {
			if (trav.data == val)
				return i;
			trav = trav.next;
		}

		return -1;
	}

	private String addEnd(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		} else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			trav.next = newNode;
		}
		return "Node Added Successfully";
	}

}
