package SinglyCircularList;

import java.util.Scanner;

class SinglyCircularlist {

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

	private Node head;

	public SinglyCircularlist() {
		head = null;
	}

	
	public void Display() {
		System.out.println("List :");
		
		if(head == null)
		{
			return;
		}
		Node trav = head;
		do {
			System.out.println(trav.data);
			trav = trav.next;
		}while(trav != head);	
	}


	public void addfirst(int val) {
		
		Node newNode  = new Node(val);
		
		if(head == null)
		{
			head = newNode;
			newNode.next=head;
		}
		else {
		Node trav =head;
		while(trav.next != head)
		{
			trav = trav.next;
		}
		
		newNode.next=head;
		trav.next=newNode;
		head= newNode;
		}		
	}


	public void addLast(int val1) {
		Node newNode = new Node(val1);
		if(head == null)
		{
			head = newNode;
			newNode.next=head;
		}else {
		Node trav=head;
		while(trav.next != head)
		{
			trav = trav.next;
		}
		trav.next= newNode;
		newNode.next=head;
		}
	}


	public void addAtPos(int val2, int pos) {
		
		Node newNode = new Node(val2);
		if(head == null || pos <=1)
		{
			addfirst(val2);
		}
		else {
		Node trav = head;
		for(int i=1;i<pos-1;i++)
		{
			if(trav.next == head)
			{
				break;
			}
			trav = trav.next;
			
		}
		newNode.next= trav.next; 
		trav.next=newNode;
	}
	}


	public void deleteFirst() {
		
		if(head == null)
		{
			throw new RuntimeException("list is empty");
		}
		
		if(head.next == head)
		{
			head = null;
		}else {
			
		Node trav=head;
		while(trav.next   !=  head)
		{
			trav = trav.next;
		}
		head= head.next;
		trav.next=head;
	}
	}


	public void deleteLast() {
		
		if(head == null)
		{
			throw new RuntimeException("empty list");
		}
		
		if(head.next == head)
		{
			head = null;
		}else {
		Node trav = head;
		Node temp = null;
		while(trav.next != head)
		{
			temp = trav;
			trav = trav.next;
		}
		temp.next=head;
	}
	}


	public void deleteAtPos(int pos1) {
		if(pos1 == 1)
		{
			deleteFirst();
		}
		if(head == null || pos1 <1)
		{
			throw new RuntimeException("list is empty or invalid position");
		}else {
		Node trav = head;
		Node temp=null;
		for(int i =1 ;i<pos1  ; i++)
		{
			
			if(trav.next ==  head)
			{				
					throw new RuntimeException("invalid position");			
			}
			temp = trav;
			trav = trav.next;
			
		}
		temp.next=trav.next;
		}
	}


	public void DeleteAll() {
		head.next=null;
		head= null;
		
	}
}

public class SinglyCircularmain {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			SinglyCircularlist list = new SinglyCircularlist();
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
						System.out.print("Enter the value :");
						int val = sc.nextInt();
						list.addfirst(val);
						break;
						
					case 3:
						System.out.print("Enter the value :");
						int val1 = sc.nextInt();
						list.addLast(val1);
						break;
						
					case 4:
						System.out.println("Enter the value:");
						int val2=sc.nextInt();
						System.out.println("Enter the position:");
						int pos= sc.nextInt();
						list.addAtPos(val2,pos);
						break;
						
					case 5:
						list.deleteFirst();
						break;
						
					case 6:
						try {
							list.deleteLast();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
						
					case 7:
						System.out.println("Enter the position:");
						int pos1= sc.nextInt();
						try {
							list.deleteAtPos(pos1);
						} catch (Exception e) {
						System.out.println(e.getMessage());
						}
						
						break;
						
					case 8:
						list.DeleteAll();
					}

				} catch (Exception e) {
					//System.out.println(e);
					e.printStackTrace();
				}
			}
		}

	}

}
