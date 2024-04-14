package pack;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class Slip21
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of subjects (N): ");
        int N = sc.nextInt();
        sc.nextLine(); // Consume newline

        LinkedList<String> ll = new LinkedList<>();

        System.out.println("Enter " + N + " subject names:");

        for (int i = 0; i < N; i++) {
            String subject = sc.nextLine();
            ll.add(subject);
        }

        System.out.println("Subject Names:");

        // Using Iterator to traverse through the LinkedList and print subject names
        Iterator<String> iterator = ll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        sc.close();
    }
}
