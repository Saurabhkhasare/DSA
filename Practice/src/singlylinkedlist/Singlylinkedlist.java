package singlylinkedlist;

import java.util.Scanner;

public class Singlylinkedlist {

    public class Node {
        private int data;
        private Node next;

        public Node() {
            super();
            this.data = 0;
            this.next = null;
        }

        public Node(int data) {
            super();
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public Singlylinkedlist() {
        super();
        this.head = null;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Singlylinkedlist list = new Singlylinkedlist();

            boolean exit = false;
            while (!exit) {
                try {
                    System.out.println("Choose :\n" + "1.Add element at end\n" + "2.Add element X at index i\n"
                            + "3.Remove all occurrence of X from the list\n" + "4.Display all elements\n"
                            + "5.Reverse the linked list\n" + "0.Exit\n");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter the element to add at end");
                            list.add(sc.nextInt());
                            break;
                        case 2:
                            System.out.println("Enter the index and value to add");
                            list.addAtIndex(sc.nextInt(), sc.nextInt());
                            break;
                        case 3:
                            System.out.println("Enter the value to remove");
                            list.removeAt(sc.nextInt());
                            break;
                        case 4:
                            list.display();
                            break;
                        case 5:
                            list.reverse();
                            break;
                        case 0:
                            exit = true;
                            System.out.println("Exiting the program");
                            break;
                        default:
                            System.out.println("Invalid choice. Please choose again.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
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
        display();
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        System.out.println("Reversed List:");
        display();
    }

    private void removeAt(int val2) {
        if (head == null) {
            System.out.println("List is already empty!!");
        } else {
            Node trav = head;
            Node temp = null;
            while (trav != null) {
                if ((trav.data == val2) && (trav == head)) {
                    head = head.next;
                    trav = head; 
                } else if (trav.data == val2) {
                    temp.next = trav.next;
                    trav = temp.next;  
                }
                temp = trav;
                if (trav != null) {
                    trav = trav.next;
                }
            }
        }
    }

    private void addAtIndex(int pos, int val1) {
        Node newNode = new Node(val1);
        if (pos <= 0) {
            System.out.println("Invalid index. Index should be greater than 0.");
            return;
        }
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node trav = head;

            for (int i = 1; i < pos - 1; i++) {

                if (trav.next == null)
                    break;
                trav = trav.next;
            }
            newNode.next = trav.next;
            trav.next = newNode;
        }
    }

    private void display() {
        if (head == null) {
            System.out.println("Stack is empty...");
        } else {
            Node trav = head;
            while (trav != null) {
                System.out.print(trav.data + "->");
                trav = trav.next;
            }
            System.out.println(); 
        }
    }

    private void add(int val) {
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
    }
}
