package singlylinkedlist;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomCircularSinglyLinkedlist {
    // Node class for the linked list
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Constructor to initialize an empty linked list
    public CustomCircularSinglyLinkedlist() {
        this.head = null;
    }

    // Add element X at the end of the list
    public void add(int X) {
        Node newNode = new Node(X);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself for circularity
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Point back to the head for circularity
        }
    }

    // Add element X at index i
    public void addAtIndex(int X, int i) {
        if (i < 0) {
            System.out.println("Invalid index. Index should be non-negative.");
            return;
        }

        Node newNode = new Node(X);
        if (i == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int j = 0; j < i - 1; j++) {
                if (current == null) {
                    System.out.println("Invalid index. Index out of bounds.");
                    return;
                }
                current = current.next;
            }

            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            } else {
                System.out.println("Invalid index. Index out of bounds.");
            }
        }
    }

    // Remove all occurrences of X from the list
    public void removeOf(int X) {
        Node current = head;
        Node prev = null;

        do {
            if (current.data == X) {
                if (prev == null) {
                    // If X is in the head node
                    head = current.next;
                    current = head;
                } else {
                    prev.next = current.next;
                    current = current.next;
                }
            } else {
                prev = current;
                current = current.next;
            }
        } while (current != head);
    }

    // Remove element present at index i
    public void removeAt(int i) {
        if (i < 0) {
            System.out.println("Invalid index. Index should be non-negative.");
            return;
        }

        if (i == 0 && head != null) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;

        for (int j = 0; j < i; j++) {
            if (current == null) {
                System.out.println("Invalid index. Index out of bounds.");
                return;
            }
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Invalid index. Index out of bounds.");
        }
    }

    // Display all elements in the list
    public void display() {
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Reverse the linked list
    public void reverse() {
        if (head == null || head.next == head) {
            return;
        }

        Node prev = null;
        Node current = head;
        Node next;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        head.next = prev; // Adjust the head to point to the new end
        head = prev;      // Update the head
        System.out.println("Reversed list");
        display();
    }

    // Returns comma-separated elements from start to end
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;

        do {
            result.append(current.data);
            if (current.next != head) {
                result.append(", ");
            }
            current = current.next;
        } while (current != head);

        return result.toString();
    }

    // Adds given list of X to the current list such that the list remains sorted
    public void addAll(List<Integer> list) {
        for (int element : list) {
            add(element);
        }
        // Assuming the list is initially sorted, you can sort it using Collections.sort if needed.
        // Collections.sort(list);
        // Then, iterate over the sorted list and add elements to the current list.
    }

    // Returns the position of X in the list. Returns -1 if X does not exist in the list.
    public int find(int X) {
        Node current = head;
        int position = 0;

        do {
            if (current.data == X) {
                return position;
            }
            current = current.next;
            position++;
        } while (current != head);

        return -1; // X not found in the list
    }

    // Returns true if the list is sorted else false
    public boolean isSorted() {
        Node current = head;

        do {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        } while (current.next != head);

        return true;
    }

    // Adds element X at the beginning of the list
    public void addFirst(int X) {
        Node newNode = new Node(X);
        newNode.next = head;
        head = newNode;
    }

    // Removes the first element from the list
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("List is already empty.");
        }
    }

    // Removes the last element from the list
    public void removeLast() {
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node current = head;
            Node prev = null;

            do {
                prev = current;
                current = current.next;
            } while (current.next != head);

            prev.next = head;
        }
    }

    public static void main(String[] args) {
    	CustomCircularSinglyLinkedlist linkedList = new CustomCircularSinglyLinkedlist();
        List<Integer> listToAdd = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an operation:");
            System.out.println("1. Add element at the end");
            System.out.println("2. Add element at index");
            System.out.println("3. Remove all occurrences of element");
            System.out.println("4. Remove element at index");
            System.out.println("5. Display all elements");
            System.out.println("6. Reverse the linked list");
            System.out.println("7. Print elements as a tostring");
            System.out.println("8. Add all elements from a list");
            System.out.println("9. Find position of an element");
            System.out.println("10. Check if the list is sorted");
            System.out.println("11. Add element at the beginning");
            System.out.println("12. Remove first element");
            System.out.println("13. Remove last element");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the element to add at the end:");
                    int elementToAdd = scanner.nextInt();
                    linkedList.add(elementToAdd);
                    break;
                case 2:
                    System.out.println("Enter the index and element to add:");
                    int indexToAdd = scanner.nextInt();
                    int elementToAddAtIndex = scanner.nextInt();
                    linkedList.addAtIndex(elementToAddAtIndex, indexToAdd);
                    break;
                case 3:
                    System.out.println("Enter the element to remove:");
                    int elementToRemove = scanner.nextInt();
                    linkedList.removeOf(elementToRemove);
                    break;
                case 4:
                    System.out.println("Enter the index to remove:");
                    int indexToRemove = scanner.nextInt();
                    linkedList.removeAt(indexToRemove);
                    break;
                case 5:
                    System.out.println("Elements in the list:");
                    linkedList.display();
                    break;
                case 6:
                    linkedList.reverse();
                    System.out.println("List reversed.");
                    break;
                case 7:
                    System.out.println("List as a string: " + linkedList.toString());
                    break;
                case 8:
                    System.out.println("Enter number of element to be insert");
                    int count = scanner.nextInt();
                    for (int i = 1; i <= count; i++) {
                        System.out.println("Enter " + i + " number of element to be add : ");
                        listToAdd.add(scanner.nextInt());
                    }
                    linkedList.addAll(listToAdd);
                    break;
                case 9:
                    System.out.println("Enter the element to find:");
                    int elementToFind = scanner.nextInt();
                    int position = linkedList.find(elementToFind);
                    if (position != -1) {
                        System.out.println("Element found at position: " + position);
                    } else {
                        System.out.println("Element not found in the list.");
                    }
                    break;
                case 10:
                    if (linkedList.isSorted()) {
                        System.out.println("The list is sorted.");
                    } else {
                        System.out.println("The list is not sorted.");
                    }
                    break;
                case 11:
                    System.out.println("Enter the element to add at the beginning:");
                    int elementToAddFirst = scanner.nextInt();
                    linkedList.addFirst(elementToAddFirst);
                    break;
                case 12:
                    linkedList.removeFirst();
                    System.out.println("First element removed.");
                    break;
                case 13:
                    linkedList.removeLast();
                    System.out.println("Last element removed.");
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        scanner.close();
    }
}

