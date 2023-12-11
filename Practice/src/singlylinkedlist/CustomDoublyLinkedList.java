package singlylinkedlist;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomDoublyLinkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public CustomDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int X) {
        Node newNode = new Node(X);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAtIndex(int X, int i) {
        if (i < 0) {
            System.out.println("Invalid index. Index should be non-negative.");
            return;
        }

        Node newNode = new Node(X);
        if (i == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
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

            newNode.prev = prev;
            newNode.next = current;

            if (current != null) {
                current.prev = newNode;
            } else {
                tail = newNode;
            }

            if (prev != null) {
                prev.next = newNode;
            } else {
                head = newNode;
            }
        }
    }

    public void removeOf(int X) {
        Node current = head;

        while (current != null) {
            if (current.data == X) {
                if (current.prev == null) {
                    // If X is in the head node
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } else {
                        tail = current.prev;
                    }
                }
            }
            current = current.next;
        }
    }

    public void removeAt(int i) {
        if (i < 0) {
            System.out.println("Invalid index. Index should be non-negative.");
            return;
        }

        if (i == 0 && head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node current = head;

        for (int j = 0; j < i; j++) {
            if (current == null) {
                System.out.println("Invalid index. Index out of bounds.");
                return;
            }
            current = current.next;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
        } else {
            System.out.println("Invalid index. Index out of bounds.");
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
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

    public void addAll(List<Integer> list) {
        for (int element : list) {
            add(element);
        }
    }

    public int find(int X) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.data == X) {
                return position;
            }
            current = current.next;
            position++;
        }

        return -1;
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

    public void addFirst(int X) {
        Node newNode = new Node(X);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            System.out.println("List is already empty.");
        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.prev.next = null;
        }
    }

    public static void main(String[] args) {
        CustomDoublyLinkedList linkedList = new CustomDoublyLinkedList();
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
