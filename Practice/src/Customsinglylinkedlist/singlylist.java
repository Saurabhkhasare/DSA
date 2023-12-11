package Customsinglylinkedlist;

import java.util.Scanner;

public class singlylist {

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

    public singlylist() {
        head = null;
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            singlylist list = new singlylist();
            boolean exit = false;
            while (!exit) {
                try {
                    System.out.println("Choose :\n" +
                            "1. Add element at end\n" +
                            "2. Find element X \n" +
                            "3. ToString \n" +
                            "4. To check list is Sorted (in Ascending Order) \n" +
                            "0. Exit\n");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter a value: ");
                            list.addEnd(sc.nextInt());
                            break;
                        case 2:
                            System.out.println("Enter an element : ");
                            int result = list.find(sc.nextInt());
                            if (result != -1) {
                                System.out.println("Element found at position: " + result);
                            } else {
                                System.out.println("Element not found in the list.");
                            }
                            break;
                        case 3:
                            System.out.println("List: " + list);
                            break;
                        case 4:
                            if (list.isSorted()) {
                                System.out.println("The list is sorted.");
                            } else {
                                System.out.println("The list is not sorted.");
                            }
                            break;
                        case 0:
                            exit = true;
                            System.out.println("Bye!");
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Please try again!!!");
                    sc.nextLine();
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isSorted() {
        Node trav = head;
        while (trav != null && trav.next != null) {
            if (trav.data > trav.next.data) {
                return false;
            }
            trav = trav.next;
        }
        return true;
    }

    private int find(int val) {
        Node trav = head;
        for (int i = 1; trav != null; i++) {
            if (trav.data == val) {
                return i;
            }
            trav = trav.next;
        }
        return -1;
    }

    private boolean addEnd(int val) {
        if (val < 0) {
            System.out.println("Negative values are not allowed.");
            return false;
        }

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

        System.out.println("Node added.");
        return true;
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
}
