package sortedsinglylinkedlist;

import java.util.ArrayList;
import java.util.Scanner;

public class SortedSinglyList {

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

	public SortedSinglyList() {
		// TODO Auto-generated constructor stub
		head = null;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			SortedSinglyList list = new SortedSinglyList();
			ArrayList<Integer> list2 = new ArrayList<>();
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Enter choice : \n" + "1.Add element X\n" + "2.Add All\n"
							+ "3.Remove element at index\n" + "4.Display List\n" + "5.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter a number to add : ");
						list.add(sc.nextInt());
						break;
					case 2:
						System.out.println("Enter number of element to be insert");
						int count = sc.nextInt();
						for (int i = 1; i <= count; i++) {
							System.out.println("Enter "+i+"  number of element to be add : ");
							list2.add(sc.nextInt());
						}
						list.addAll(list2);
						break;
					case 3:
						System.out.println("Enter index number to remove: ");
						list.removeAt(sc.nextInt());
						break;
					case 4:
						System.out.println(list.toString());
						break;
					case 5:
						exit = true;
						System.out.println("Byeee");
						break;
					default:
						break;
					}
				} catch (Exception e) {
					System.out.println("please try again!!!");
					e.printStackTrace();
				}
			}
		}
	}

	private void addAll(ArrayList<Integer> list2) {
		for (Integer item : list2)
				add(item);
	}

//	@Override
//	public String toString() {
//		displayAll();
//		return "";
//	}
	  @Override
	    public String toString() {
	        StringBuilder result = new StringBuilder();
	        Node current = head;

	        while (current != null) {
	            result.append(current.data);
	            if (current.next != null) {
	                result.append(", ");
	            }
	            current = current.next;
	        }

	        return result.toString();
	    }

//	private void removeAt(int index) {
//		Node trav = head;
//		Node temp = null;
//		for (int i = 1; i < index; i++) {
//			temp = trav;
//			trav = trav.next;
//		}
//		temp.next = trav.next;
//	}
	private void removeAt(int index) {
        if (index <= 0 || head == null) {
            System.out.println("Invalid index or list is empty");
            return;
        }

        if (index == 1) {
            head = head.next;
            return;
        }

        Node trav = head;
        Node temp = null;
        for (int i = 1; i < index && trav != null; i++) {
            temp = trav;
            trav = trav.next;
        }
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

	private void add(int value) {
		// TODO Auto-generated method stub
		Node newNode = new Node(value);
		if (head == null)
			head = newNode;
		else {
			Node trav = head;
			Node temp = null;
			while (trav != null && trav.data < value) {
				temp = trav;
				trav = trav.next;
			}
			// If upcoming variable is least from the list-- adding At first
			if (trav == head) {
				newNode.next = head;
				head = newNode;
			} else {// upcoming varibale is in between
				newNode.next = temp.next;
				temp.next = newNode;
			}
		}
	}

}
