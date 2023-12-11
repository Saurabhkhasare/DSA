package question2;

import java.util.Scanner;

public class SinglyLinkedList {

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

	public SinglyLinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// D.S
			SinglyLinkedList list = new SinglyLinkedList();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Choose :\n" + "1.Add element at end\n" + "2.Add element X at index i\n"
							+ "3.Remove all occurrence of X from the list\n" + "4.Display all elements\n"
							+ "5.Reverse the linked list\n" + "0.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter a value: ");
						System.out.println(list.addEnd(sc.nextInt()));
						break;
					case 2:
						System.out.println("Enter a value and position: ");
						System.out.println(list.addPos(sc.nextInt(),sc.nextInt()));
						break;
					case 3:
						System.out.println("Enter the number to remove it ALL occurenece");
						list.removeOf(sc.nextInt());
						break;
					case 4:
						list.displayAll();
						break;
					case 5:
						list.reverse();
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
	private void reverse() {
	    if (head == null) {
	        System.out.println("List is already empty!!");
	        return;
	    }

	    System.out.println("Old List:");
	    displayAll();

	    Node prev = null;
	    Node current = head;
	    Node next = null;

	    while (current != null) {
	        next = current.next; // Save the next node
	        current.next = prev; // Reverse the link
	        prev = current; // Move to the next nodes
	        current = next;
	    }

	    head = prev; // Update the head to the new start of the reversed list

	    System.out.println("Reversed List:");
	    displayAll();
	}

	private void removeOf(int val) {
		if(head==null)
			System.out.println("List is already empty!!");
		else {
			Node trav = head;
			Node temp = null;
			while(trav!=null) {
				if((trav.data==val)&&(trav==head)) {
					head = head.next;
				}
				else if(trav.data==val) {
					temp.next = trav.next;
				}
				temp = trav;
				trav = trav.next;	
			}
			System.out.println("Removed all occurence of "+val+" Successfully");
		}
		
	}

	private String addPos(int val, int pos) {
	Node newNode = new Node(val);
		if(head==null) {
			head = newNode;
		}else {
			Node trav = head;
			for(int i=1;i<pos-1;i++) {
				if(trav.next==null)
					break;
				trav= trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
		}
		return "Node Added Successfully";
	}

	private void displayAll() {
		if (head == null) {
			System.out.println("List is empty!!!!");
		} else {
			Node trav = head;
			while (trav != null) {
				System.out.print(trav.data + "->");
				trav = trav.next;
			}
		}
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
