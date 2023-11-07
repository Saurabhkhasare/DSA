package LinkedListSort;

import java.util.Iterator;

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
	
	public void addlast(int val)
	{
		Node newNode = new Node(val);
		if(head ==  null)
		{
			head= newNode;
		}
		else {
			Node trav=head;
			while(trav.next != null)
			{
				trav=trav.next;
			}
			trav.next=newNode;	
		}
	}
	
	public void Display()
	{
		System.out.println("List:");
		Node trav=head;
		while(trav != null)
		{
			System.out.print(trav.data+" -> ");
			trav=trav.next;
		}
		System.out.println();
	}
	
	public void reverse()
	{//consider current list as old and new list as empty
		Node oldhead = head;
		head = null;
		
		while(oldhead != null) {
			//delete first (temp) from old list
		Node temp = oldhead;
		oldhead = oldhead.next;
		//add first(temp) to new list
		temp.next=head;
		head=temp;
		}//repeat until old list is finished
		
	}
	
	public Node recursionreverse(Node h)
	{
		if(h.next == null || head == null)
		{
			head = h;
			return head;
		}
		Node newhead = recursionreverse(h.next);
		newhead.next = h;
		h.next=null;
		return h;	
	}
	
	public void recursionreverse() {
		
			recursionreverse(head);		
	}
	
	private void revDisplay(Node h)
	{
		if(h == null)
		{
			return;
		}
		
		revDisplay(h.next);
		System.out.print(h.data+" ->");
	}
	
	public void revDisplay()
	{
		System.out.print("List :");
		revDisplay(head);
		System.out.println(" ");
	}
	
	//Approch=1 to find mid
	public void findMid()
	{
		int count=0;
		Node trav =head;
		while(trav != null)
		{	
			count++;
			trav=trav.next;		
		}
		trav =head;//again we have to declare for travsering.....
		for(int i=0;i<count/2;i++)
		{
			trav=trav.next;
			
		}
		System.out.println("Middle :"+trav.data);
	}
	
	//Approch=2 to find mid
	public int FindMid()
	{
		//use two pointer fast and slow
		Node fast=head, slow=head;
		//here check if ur fast.next pointer is pointing to null or not and if ur fast is null or not
		while(fast != null && fast.next != null)
		{
			//here slow will be trverse single ,single node
			slow = slow.next;
			//here fast will traverse double node
			fast = fast.next.next;
		}
		return slow.data;//here middle element were return
	}
}
public class LinkedListMain {

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.addlast(10);
		list.addlast(20);
		list.addlast(30);
		list.addlast(40);
		list.addlast(50);
		list.Display();
		
//		list.reverse();
//		list.Display();
		
//		list.recursionreverse();
//		list.Display();
		
	//	list.revDisplay();
	
	//	System.out.println("Middle :" +list.FindMid());
		list.findMid();
		
	}

}
