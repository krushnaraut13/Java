package pack;

import java.util.LinkedList;
import java.util.Scanner;

public class Slip19 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of integers (N): ");
        int N = sc.nextInt();

        LinkedList<Integer> ll = new LinkedList<>();

        System.out.println("Enter " + N + " integers:");

        for (int i = 0; i < N; i++) 
        {
            int num = sc.nextInt();
            ll.add(num);
        }

        System.out.println("Negative Integers:");

        for (int num : ll) 
        {
            if (num < 0) 
            {
                System.out.println(num);
            }
        }

        sc.close();
    }
}

