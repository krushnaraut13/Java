package pack;

import java.util.*;

public class Slip6 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        // Accepting 'n' integers from the user
        System.out.print("Enter the number of integers (n): ");
        int n = sc.nextInt();
        
        TreeSet<Integer> TS = new TreeSet<>(); // Using TreeSet to automatically sort and eliminate duplicates
        
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
        {
            int num = sc.nextInt();
            TS.add(num);
        }
        
        // Displaying integers in sorted order without duplicates
        System.out.println("Integers in sorted order without duplicates:");
        for (int num : TS) 
        {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Searching for a particular element
        System.out.print("Enter the element to search for: ");
        int searchElement = sc.nextInt();
        
        if (TS.contains(searchElement)) 
        {
            System.out.println(searchElement + " is found in the collection.");
        } else 
        {
            System.out.println(searchElement + " is not found in the collection.");
        }
        
        sc.close();
    }
}
