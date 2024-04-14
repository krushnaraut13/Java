package pack;

import java.util.LinkedList;

public class Slip29b {
    public static void main(String[] args) {
        // Create a LinkedList of integer objects
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Add elements at the first position
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        linkedList.addFirst(40);

        // Display the LinkedList
        System.out.println("LinkedList after adding elements at first position: " + linkedList);

        // Delete the last element
        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
            System.out.println("LinkedList after deleting last element: " + linkedList);
        } else {
            System.out.println("LinkedList is empty, cannot delete last element.");
        }

        // Display the size of the LinkedList
        System.out.println("Size of LinkedList: " + linkedList.size());
    }
}
