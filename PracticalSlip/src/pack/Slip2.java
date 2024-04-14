package pack;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Slip2 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        HashSet<String> friendNames = new HashSet<>();

        System.out.print("Enter the number of friends: ");
        int numberOfFriends = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= numberOfFriends; i++) {
            System.out.print("Enter name of friend " + i + ": ");
            String name = scanner.nextLine();
            friendNames.add(name);
        }

        Set<String> sortedNames = new TreeSet<>(friendNames);

        System.out.println("\nFriends in ascending order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
