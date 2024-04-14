package pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Slip23 {

    public static void main(String[] args) {
        // Create a List to store student names
        List<String> ll = new ArrayList<>();

        // Check if command line arguments are provided
        if (args.length == 0) 
        {
            System.out.println("Please provide at least one student name as a command line argument.");
            return;
        }

        // Add student names to the list
        for (String arg : args) 
        {
            ll.add(arg);
        }

        // Display student names using Iterator
        System.out.println("Student names using Iterator:");
        displayStudentNamesUsingIterator(ll);

        // Display student names using ListIterator
        System.out.println("\nStudent names using ListIterator:");
        displayStudentNamesUsingListIterator(ll);
    }

    // Method to display student names using Iterator
    public static void displayStudentNamesUsingIterator(List<String> studentNames) {
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Method to display student names using ListIterator
    public static void displayStudentNamesUsingListIterator(List<String> studentNames) {
        ListIterator<String> listIterator = studentNames.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
