package pack;

import java.util.LinkedList;

public class Slip3{
    public static void main(String[] args) {
        // Create a LinkedList of String objects
        LinkedList<String> ll = new LinkedList<>();

        // Add elements at the end of the list
        ll.add("Apple");
        ll.add("Banana");
        ll.add("Cherry");
        ll.add("Date");

        // Display the contents of the list
        System.out.println("Contents of the list:");
        System.out.println(ll);

        // Delete the first element of the list
        if (!ll.isEmpty()) 
        {
            ll.removeFirst();
            System.out.println("\nAfter deleting the first element:");
            System.out.println(ll);
        } else 
        {
            System.out.println("List is empty. Cannot delete.");
        }

        // Display the contents of the list in reverse order
        System.out.println("\nContents of the list in reverse order:");
        for (int i = ll.size() - 1; i >= 0; i--) {
            System.out.println(ll.get(i));
        }
    }
}
