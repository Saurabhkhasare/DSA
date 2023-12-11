package sortedsinglylinkedlist;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomSortedSinglyList {

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

    public CustomSortedSinglyList() {
        head = null;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        	CustomSortedSinglyList list = new CustomSortedSinglyList();
            ArrayList<Integer> list2 = new ArrayList<>();
            boolean exit = false;

            while (!exit) {
                try {
                    System.out.println("Enter choice : \n" +
                            "1. Add element X\n" +
                            "2. Add All\n" +
                            "3. Remove element at index\n" +
                            "4. Display List\n" +
                            "5. Display comma-separated elements\n" +
                            "6. Check if the list is sorted\n" +
                            "7. Add element at the end\n" +
                            "8. Delete first element\n" +
                            "9. Delete last element\n" +
                            "10. Reverse the list\n" +
                            "11. Exit");

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
                            System.out.println("Comma-separated elements: " + list.toString());
                            break;
                        case 6:
                            if (list.isSorted()) {
                                System.out.println("The list is sorted.");
                            } else {
                                System.out.println("The list is not sorted.");
                            }
                            break;
                        case 7:
                            System.out.println("Enter a number to add at the end: ");
                            list.addLast(sc.nextInt());
                            break;
                        case 8:
                            list.deleteFirst();
                            System.out.println("First element deleted.");
                            break;
                        case 9:
                            list.deleteLast();
                            System.out.println("Last element deleted.");
                            break;
                        case 10:
                            list.reverse();
                            System.out.println("List reversed.");
                            break;
                        case 11:
                            exit = true;
                            System.out.println("Bye!");
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
            return;
        }

        Node trav = head;
        Node temp = null;
        for (int i = 1; i < index && trav != null; i++) {
            temp = trav;
            trav = trav.next;
        }

        if (trav != null) {
            temp.next = trav.next;
        } else {
            System.out.println("Invalid index. Index out of bounds.");
        }
    }

    private void deleteFirst() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("List is already empty.");
        }
    }

    private void deleteLast() {
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            Node prev = null;

            while (current.next != null) {
                prev = current;
                current = current.next;
            }

            prev.next = null;
        }
    }

    private void add(int value) {
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
            if (trav == head) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = temp.next;
                temp.next = newNode;
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

        return true;
    }

    private void addLast(int value) {
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

    private void reverse() {
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
        System.out.println("Reversed list");
        System.out.println(toString());
    }
}
