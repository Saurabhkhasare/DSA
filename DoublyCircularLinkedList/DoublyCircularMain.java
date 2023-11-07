package DoublyCircularLinkedList;

import java.util.Scanner;




class DoublyList {

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

	public DoublyList() {
		head = null;
	}

	public void ForwardDisplay() {
		System.out.println("Forward list");
		   if (head == null) {
		        System.out.println("List is empty");
		        return;
		    }
		Node trav=head;
		do {
			System.out.println(trav.data);
			trav=trav.next;
		}while(trav.next != head.next);
		
	}

	public void ReverseDisplay() {
		System.out.println("Reverse list");
		  if (head == null) {
		        System.out.println("List is empty");
		        return;
		    }
		Node trav=head.prev;
		do {
			System.out.println(trav.data);
			trav=trav.prev;
		}while(trav != head.prev);
		
	}

	public void addfirst(int val) {
		
		Node newNode = new Node(val);
		if(head == null)
		{
			head = newNode;
			newNode.next=head;
			newNode.prev=head;
		}else {
		Node trav=head;
		Node tail;
		while(trav != head)
		{
			trav = trav.next;
		}
		tail=head.prev;
		newNode.next= head;
		newNode.prev=tail;
		tail.next=newNode;
		head.prev=newNode;
		head=newNode;
		}
	}
	
	public void addLast(int val) {
		Node newNode = new Node(val);
		if(head == null)
		{
			head = newNode;
			newNode.next=head;
			newNode.prev=head;
		}else {
		Node trav=head;
		Node tail;
		while(trav != head)
		{
			trav = trav.next;
		}
		tail=head.prev;
		newNode.next= head;
		newNode.prev=tail;
		tail.next=newNode;
		head.prev=newNode;
	
		
		}
		
	}

	public void addAtPos(int pos, int val) {
		Node newNode = new Node(val);
		if(head == null || pos < 1)
		{
			addfirst(val);
		}
		else {
		Node trav = head;
		for(int i=1;i<pos-1;i++)
		{
			if(trav.next == head)
			{
				break;
			}
			trav=trav.next;
		}
		newNode.next=trav.next;
		trav.next.prev=newNode;
		trav.next=newNode;
		newNode.prev=trav;	
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
			//pointed to last node through head.prev becoz head.prev have last node address
			Node tail = head.prev;
		//move head to next node to delete first node
		head=head.next;
		//we store tails's head in head.prev
		head.prev=tail;
		//here in tail.next we store head which is changed
		 tail.next=head;	
			
		}
	}

	public void deletelast() {
		if(head == null)
		{
			throw new RuntimeException("list is empty");
		}
		
		if(head.next == head)
		{
			head = null;
		}else {
			
			Node tail=head.prev;
			tail=tail.prev;
			tail.next=head;
			head.prev=tail;
			
		}
		
	}

	public void deleteAtPos(int pos) {
		if(pos == 1)
		{
			deleteFirst();
		}
		if(head == null || pos <1)
		{
			throw new RuntimeException("list is empty or invalid position");
		}else {
		Node trav=head;
		
		for (int i = 1; i < pos; i++) {
			
			if(trav.next ==  head)
			{				
					throw new RuntimeException("invalid position");			
			}
			trav=trav.next;		
		}
		
		trav.prev.next=trav.next;
		trav.next.prev=trav.prev;
		if(trav.next == head)
		{
			Node tail=trav.prev;
		}
		}
	}

	public void deleteAll() {
		head.next=null;
		head= null;
		
	}
		
}

public class DoublyCircularMain {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			DoublyList list = new DoublyList();
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
						System.out.println("Enter the value:");
						int val = sc.nextInt();
						list.addfirst(val);
						break;
						
					case 3:
						System.out.println("Enter the value:");
						val = sc.nextInt();
						list.addLast(val);
						break;
						
					case 4:
						System.out.print("Enter the position: ");
						int pos = sc.nextInt();
						System.out.print("Enter the value: ");
						val = sc.nextInt();
						list.addAtPos(pos,val);
						break;
						
					case 5:
						list.deleteFirst();
						break;
						
					case 6:
						list.deletelast();
						break;
						
					case 7:
						System.out.println("Enter the position to delete:");
						pos = sc.nextInt();
						list.deleteAtPos(pos);
						break;
						
					case 8:
						list.deleteAll();
						break;
					}
				} catch (Exception e) {
					//System.out.println(e);
					e.printStackTrace();

				}
			}
		}

	}

}
