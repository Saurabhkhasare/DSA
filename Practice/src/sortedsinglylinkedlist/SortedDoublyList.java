package sortedsinglylinkedlist;


import java.util.ArrayList;
import java.util.Scanner;

public class SortedDoublyList {

    class Node {
        private int data;
        private Node prev;
        private Node next;

        Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public SortedDoublyList() {
        head = null;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            SortedDoublyList list = new SortedDoublyList();
            ArrayList<Integer> list2 = new ArrayList<>();
            boolean exit = false;

            while (!exit) {
                try {
                    System.out.println("Enter choice : \n" +
                            "1. Add element X\n" +
                            "2. Add All\n" +
                            "3. Remove element at index\n" +
                            "4. Display List\n" +
                            "5. Exit");

                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter a number to add : ");
                            list.add(sc.nextInt());
                            break;
                        case 2:
                            System.out.println("Enter number of elements to be inserted");
                            int count = sc.nextInt();
                            for (int i = 1; i <= count; i++) {
                                System.out.println("Enter " + i + " number of element to be added : ");
                                list2.add(sc.nextInt());
                            }
                            list.addAll(list2);
                            break;
                        case 3:
                            System.out.println("Enter index to remove element at that index: ");
                            list.removeAt(sc.nextInt());
                            break;
                        case 4:
                            System.out.println(list.toString());
                            break;
                        case 5:
                            exit = true;
                            System.out.println("Bye!");
                            break;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Please try again!!!");
                    e.printStackTrace();
                }
            }
        }
    }

    private void addAll(ArrayList<Integer> list2) {
        for (Integer item : list2)
            add(item);
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

    private void removeAt(int index) {
        if (index <= 0 || head == null) {
            System.out.println("Invalid index or list is empty");
            return;
        }

        if (index == 1) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            Node trav = head;
            Node temp = null;
            for (int i = 1; i < index && trav != null; i++) {
                temp = trav;
                trav = trav.next;
            }

            if (trav != null) {
                temp.next = trav.next;
                if (trav.next != null) {
                    trav.next.prev = temp;
                }
            } else {
                System.out.println("Invalid index. Index out of bounds.");
            }
        }
    }

    private void add(int value) {
        Node newNode = new Node(value);
        if (head == null || head.data >= value) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null && current.next.data < value) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
    }
}

