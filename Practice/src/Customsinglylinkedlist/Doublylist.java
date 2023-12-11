package Customsinglylinkedlist;

import java.util.Scanner;

public class Doublylist {

    public class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node() {
            super();
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        public Node(int val) {
            super();
            this.data = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public Doublylist() {
        super();
        this.head = null;
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            Doublylist list = new Doublylist();
            boolean exit = false;

            while (!exit) {
                System.out.println("1.Display \r\n" + "2.addfirst \r\n" + "3.addlast  \r\n" + "4.addAtpos  \r\n"
                        + "5.deletefirst  \r\n" + "6.deletelast  \r\n" + "7.deleteAtPos  \r\n" + "8.deleteAll \r\n"
                        + "9.find the element \r\n" + "10.Displya toString \r\n" + " 11.check isSorted");
                System.out.println("Enter the choice");

                try {
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("List:");
                            list.display();
                            break;
                        case 2:
                            System.out.println("Enter the element");
                            list.addfirst(sc.nextInt());
                            break;
                        case 3:
                            System.out.println("Enter the element");
                            list.addLast(sc.nextInt());
                            break;
                        case 4:
                            System.out.println("Enter position and element");
                            list.addAtPos(sc.nextInt(), sc.nextInt());
                            break;
                        case 5:
                            list.deleteFirst();
                            break;
                        case 6:
                            list.deleteLast();
                            break;
                        case 7:
                            System.out.println("Enter the position to delete");
                            list.deleteAtPos(sc.nextInt());
                            break;
                        case 8:
                            list.deleteAll();
                            break;
                        case 9:
                            System.out.print("Enter the element to find:");
                            int elementToFind = sc.nextInt();
                            int position = list.find(elementToFind);
                            if (position != -1) {
                                System.out.println("Element found at position: " + position);
                            } else {
                                System.out.println("Element not found in the list.");
                            }
                            break;
                        case 10:
                            System.out.println("List as a string: " + list.toString());
                            break;
                        case 11:
                            if (list.isSorted()) {
                                System.out.println("The list is sorted.");
                            } else {
                                System.out.println("The list is not sorted.");
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public boolean isSorted() {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }

        return true; // List is sorted
    }

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

    private int find(int val2) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.data == val2) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1; // Element not found
    }

    private void deleteAtPos(int pos) {
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

    private void deleteAll() {
        head.next = null;
        head = null;
    }

    private void deleteLast() {
        if (head == null) {
            throw new RuntimeException("empty list");
        }
        if (head.next == null) {
            head = null;
        } else {
            Node temp = null, trav = head;
            while (trav.next != null) {
                temp = trav;
                trav = trav.next;
            }
            temp.next = null;
        }
    }

    private void deleteFirst() {
        if (head == null) {
            throw new RuntimeException("empty list");
        }
        if (head.next == null) {
            head = null;
        } else {
            Node trav = head;
            head = trav.next;
            head.prev = null;
        }
    }

    private void addAtPos(int pos, int val2) {
        Node newNode = new Node(val2);
        if (head == null || pos < 1) {
            addfirst(val2);
        } else {
            Node trav = head, temp;
            for (int i = 1; i < pos - 1; i++) {
                if (trav.next == null)
                    break;
                trav = trav.next;
            }
            temp = trav;
            newNode.next = trav.next;
            newNode.prev = trav;
            trav.next = newNode;

            if (temp != null) {
                temp.prev = newNode;
            }
        }

    }

    private void display() {
        Node trav = head;
        while (trav != null) {
            System.out.println(trav.data + " ");
            trav = trav.next;
        }
    }

    private void addLast(int val1) {
        Node newNode = new Node(val1);
        if (head == null) {
            head = newNode;
        } else {
            Node trav = head;
            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = newNode;
            newNode.prev = trav;
        }

    }

    private void addfirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

}
