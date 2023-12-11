package Customsinglylinkedlist;
import java.util.Scanner;
public class AllCustom {
	


	    private class Node {
	        private int data;
	        private Node next;

	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }

	    private Node head;

	    public AllCustom() {
	        head = null;
	    }

	    public void add(int value) {
	        Node newNode = new Node(value);
	        if (head == null) {
	            head = newNode;
	        } else {
	            Node current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	        }
	    }

	    public int find(int value) {
	        Node current = head;
	        int position = 1;

	        while (current != null) {
	            if (current.data == value) {
	                return position;
	            }
	            current = current.next;
	            position++;
	        }

	        return -1;
	    }

	    public String display() {
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

	    public boolean isSorted() {
	        Node current = head;

	        while (current != null && current.next != null) {
	            if (current.data > current.next.data) {
	                return false;
	            }
	            current = current.next;
	        }

	        return true;
	    }

	    public void reverse() {
	        Node prev = null;
	        Node current = head;
	        Node nextNode=null;

	        while (current != null) {
	            nextNode = current.next;
	            current.next = prev;
	            prev = current;
	            current = nextNode;
	        }

	        head = prev;
	        display();
	        
	    }

	    public static void main(String[] args) {
	    	AllCustom list = new AllCustom();
	        Scanner scanner = new Scanner(System.in);
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("\nChoose an option:");
	            System.out.println("1. Add element");
	            System.out.println("2. Find element");
	            System.out.println("3. Display list");
	            System.out.println("4. Check if the list is sorted");
	            System.out.println("5. Reverse the list");
	            System.out.println("6. add element at index");
	            System.out.println("7. Remove");
	            System.out.println("0. Exit");

	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter a value to add:");
	                    int value = scanner.nextInt();
	                    list.add(value);
	                    break;
	                case 2:
	                    System.out.println("Enter a value to find:");
	                    int findValue = scanner.nextInt();
	                    int position = list.find(findValue);
	                    if (position != -1) {
	                        System.out.println("Position of " + findValue + ": " + position);
	                    } else {
	                        System.out.println(findValue + " not found in the list.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("List: " + list.display());
	                    break;
	                case 4:
	                    boolean sorted = list.isSorted();
	                    System.out.println("Is the list sorted? " + sorted);
	                    break;
	                case 5:
	                    list.reverse();
	                    System.out.println("List reversed.");
	                    break;
	                case 6:
	                    System.out.println("Enter a value to add:");
	                    int addValue = scanner.nextInt();
	                    System.out.println("Enter the index to add:");
	                    int addIndex = scanner.nextInt();
	                    list.addAtIndex(addValue, addIndex);
	                    break;
	                case 7:
	                    System.out.println("Enter a value to remove:");
	                    int removeValue = scanner.nextInt();
	                    list.remove(removeValue);
	                    break;
	                case 0:
	                    exit = true;
	                    System.out.println("Exiting the program. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	       
	    }

		private void addAtIndex(int addValue, int addIndex) {
		        Node newNode = new Node(addValue);
		        if (addIndex <= 0) {
		            System.out.println("Invalid index. Index should be greater than 0.");
		            return;
		        }

		        if (addIndex == 1) {
		            newNode.next = head;
		            head = newNode;
		            return;
		        }

		        Node current = head;
		        Node previous = null;
		        int currentPosition = 1;

		        while (current != null && currentPosition < addIndex) {
		            previous = current;
		            current = current.next;
		            currentPosition++;
		        }

		        if (currentPosition == addIndex) {
		            previous.next = newNode;
		            newNode.next = current;
		        } else {
		            System.out.println("Invalid index. Index out of bounds.");
		        }
		    }

		    public void remove(int value) {
		        Node current = head;
		        Node previous = null;

		        while (current != null && current.data != value) {
		            previous = current;
		            current = current.next;
		        }

		        if (current != null) {
		            if (previous == null) {
		                // Removing the first node
		                head = current.next;
		            } else {
		                previous.next = current.next;
		            }
		            System.out.println("Element " + value + " removed from the list.");
		        } else {
		            System.out.println("Element " + value + " not found in the list.");
		        }
		    }
			
//		    public void removeFirst() {
//		        if (head != null) {
//		            head = head.next;
//		            System.out.println("First element deleted.");
//		        } else {
//		            System.out.println("List is already empty.");
//		        }
//		    }
//
//		    public void removeLast() {
//		        if (head == null) {
//		            System.out.println("List is already empty.");
//		            return;
//		        }
//
//		        if (head.next == null) {
//		            head = null;
//		        } else {
//		            Node current = head;
//		            Node previous = null;
//
//		            while (current.next != null) {
//		                previous = current;
//		                current = current.next;
//		            }
//
//		            previous.next = null;
//		        }
//		        System.out.println("Last element deleted.");
//		    }
//
//		    public void removeAt(int index) {
//		        if (index <= 0 || head == null) {
//		            System.out.println("Invalid index or list is empty.");
//		            return;
//		        }
//
//		        if (index == 1) {
//		            head = head.next;
//		            System.out.println("Element at position " + index + " deleted.");
//		            return;
//		        }
//
//		        Node current = head;
//		        Node previous = null;
//		        int currentPosition = 1;
//
//		        while (current != null && currentPosition < index) {
//		            previous = current;
//		            current = current.next;
//		            currentPosition++;
//		        }
//
//		        if (currentPosition == index && current != null) {
//		            previous.next = current.next;
//		            System.out.println("Element at position " + index + " deleted.");
//		        } else {
//		            System.out.println("Invalid index. Index out of bounds.");
//		        }
//		    }
		
	}


