package Customsinglylinkedlist;

import java.util.Scanner;

public class CustomSinglyCircularList {

    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public CustomSinglyCircularList() {
        head = null;
        tail = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Make it circular
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Make it circular
        }
    }

    public int find(int value) {
        Node current = head;
        int position = 1;

        do {
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        } while (current != head);

        return -1;
    }

    public String display() {
        StringBuilder result = new StringBuilder();
        Node current = head;

        if (current != null) {
            do {
                result.append(current.data);
                if (current.next != head) {
                    result.append(", ");
                }
                current = current.next;
            } while (current != head);
        }

        return result.toString();
    }

    public boolean isSorted() {
        Node current = head;

        do {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        } while (current != head);

        return true;
    }

    public void reverse() {
        Node current = head;
        Node prev = null;
        Node next;

        if (head != null) {
            do {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            } while (current != head);

            head.next = prev;
            head = prev;
            tail = current;
        }
    }

    public void addAtIndex(int addValue, int addIndex) {
        Node newNode = new Node(addValue);

        if (addIndex <= 0) {
            System.out.println("Invalid index. Index should be greater than 0.");
            return;
        }

        if (addIndex == 1) {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Update tail to maintain circular structure
            return;
        }

        Node current = head;
        Node previous = null;
        int currentPosition = 1;

        do {
            previous = current;
            current = current.next;
            currentPosition++;
        } while (current != head && currentPosition < addIndex);

        if (currentPosition == addIndex) {
            newNode.next = current;
            previous.next = newNode;

            if (current == head) {
                tail = newNode; // Update tail for the new last node
            }
        } else {
            System.out.println("Invalid index. Index out of bounds.");
        }
    }

    public void remove(int value) {
        Node current = head;
        Node previous = null;

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        do {
            if (current.data == value) {
                if (previous == null) {
                    // Removing the first node
                    head = current.next;
                    tail.next = head; // Update tail to maintain circular structure

                    if (head == null) {
                        tail = null; // List is empty, update tail
                    }
                } else {
                    previous.next = current.next;

                    if (current == tail) {
                        tail = previous; // Update tail for the new last node
                        tail.next = head; // Update tail to maintain circular structure
                    }
                }
                System.out.println("Element " + value + " removed from the list.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Element " + value + " not found in the list.");
    }

    public static void main(String[] args) {
        CustomSinglyCircularList list = new CustomSinglyCircularList();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add element");
            System.out.println("2. Find element");
            System.out.println("3. Display list");
            System.out.println("4. Check if the list is sorted");
            System.out.println("5. Reverse the list");
            System.out.println("6. Add element at index");
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
}

