package question1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackWithTwoQueues {
    private Queue<Integer> primaryQueue;
    private Queue<Integer> secondaryQueue;

    StackWithTwoQueues() {
        primaryQueue = new LinkedList<>();
        secondaryQueue = new LinkedList<>();
    }

    // Function to push an element onto the stack
    void push(int value) {
        // Add the new element to the primary queue
        primaryQueue.add(value);
    }

    // Function to pop an element from the stack
    void pop() {
        if (primaryQueue.isEmpty()) {
            System.out.println("Stack is empty. Cannot perform pop operation.");
            return;
        }

        // Move all elements from the primary queue to the secondary queue except the last one
        while (primaryQueue.size() > 1) {
            secondaryQueue.add(primaryQueue.poll());
        }

        // Remove the last element from the primary queue (which is the top of the stack)
        System.out.println("Popped element: " + primaryQueue.poll());

        // Swap the names of the primary and secondary queues
        Queue<Integer> tempQueue = primaryQueue;
        primaryQueue = secondaryQueue;
        secondaryQueue = tempQueue;
    }

    // Function to get the top element of the stack
    void top() {
        if (primaryQueue.isEmpty()) {
            System.out.println("Stack is empty. There is no top element.");
            return;
        }

        // Move all elements from the primary queue to the secondary queue
        while (!primaryQueue.isEmpty()) {
            secondaryQueue.add(primaryQueue.poll());
        }

        // Get the top element from the secondary queue
        int topElement = secondaryQueue.peek();
        System.out.println("Top element: " + topElement);

        // Move the elements back to the primary queue
        while (!secondaryQueue.isEmpty()) {
            primaryQueue.add(secondaryQueue.poll());
        }
    }

    // Function to get the maximum element in the stack
    void getMax() {
        if (primaryQueue.isEmpty()) {
            System.out.println("Stack is empty. Cannot find the maximum element.");
            return;
        }

        int maxElement = Integer.MIN_VALUE;

        // Iterate through all elements in the primary queue to find the maximum
        for (int element : primaryQueue) {
            maxElement = Math.max(maxElement, element);
        }

        System.out.println("Maximum element: " + maxElement);
    }

    // Function to get the minimum element in the stack
    void getMin() {
        if (primaryQueue.isEmpty()) {
            System.out.println("Stack is empty. Cannot find the minimum element.");
            return;
        }

        int minElement = Integer.MAX_VALUE;

        // Iterate through all elements in the primary queue to find the minimum
        for (int element : primaryQueue) {
            minElement = Math.min(minElement, element);
        }

        System.out.println("Minimum element: " + minElement);
    }
}

