package sortedsinglylinkedlist;



import java.util.Scanner;

public class CustomCircularSortedDoublyList {

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

    public CustomCircularSortedDoublyList() {
        head = null;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        	CustomCircularSortedDoublyList list = new CustomCircularSortedDoublyList();
            boolean exit = false;

            while (!exit) {
                try {
                    System.out.println("Enter choice : \n" +
                            "1. Add element X\n" +
                            "2. Display List\n" +
                            "3. Display comma-separated elements\n" +
                            "4. Check if the list is sorted\n" +
                            "5. Add element at the end\n" +
                            "6. Delete first element\n" +
                            "7. Delete last element\n" +
                            "8. Reverse the list\n" +
                            "9. Exit");

                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter a number to add : ");
                            list.add(sc.nextInt());
                            break;
                        case 2:
                            list.display();
                            break;
                        case 3:
                            System.out.println("Comma-separated elements: " + list.toString());
                            break;
                        case 4:
                            if (list.isSorted()) {
                                System.out.println("The list is sorted.");
                            } else {
                                System.out.println("The list is not sorted.");
                            }
                            break;
                        case 5:
                            System.out.println("Enter a number to add at the end: ");
                            list.addLast(sc.nextInt());
                            break;
                        case 6:
                            list.deleteFirst();
                            System.out.println("First element deleted.");
                            break;
                        case 7:
                            list.deleteLast();
                            System.out.println("Last element deleted.");
                            break;
                        case 8:
                            list.reverse();
                            System.out.println("List reversed.");
                            break;
                        case 9:
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;

        while (current != null) {
            result.append(current.data);
            if (current.next != head) {
                result.append(", ");
            }
            current = current.next;
        }

        return result.toString();
    }

    private void deleteFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = findTail();
            }
        } else {
            System.out.println("List is already empty.");
        }
    }

    private void deleteLast() {
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node current = findTail();
            current.prev.next = head;
            head.prev = current.prev;
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
            findTail().next = head;
        } else {
            Node current = head;

            while (current.next != head && current.next.data < value) {
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

    private Node findTail() {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current.next != head) {
            current = current.next;
        }

        return current;
    }

    public boolean isSorted() {
        Node current = head;

        while (current != null && current.next != head) {
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
            findTail().next = head;
        } else {
            Node current = findTail();
            current.next = newNode;
            newNode.prev = current;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    private void reverse() {
        Node current = head;
        Node prev = null;
        Node next = null;

        do {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        } while (current != head);

        head = prev;
    }

    private void display() {
        Node trav = head;
        do {
            System.out.println(trav.data + " ");
            trav = trav.next;
        } while (trav != head);
    }
}

