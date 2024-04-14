package pack;

import java.util.Scanner;
import java.util.TreeSet;

public class Slip17
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of integers (N): ");
        int N = sc.nextInt();

        TreeSet<Integer> TS = new TreeSet<>();

        System.out.println("Enter " + N + " integers:");

        for (int i = 0; i < N; i++) 
        {
            int num = sc.nextInt();
            TS.add(num);
        }

        System.out.println("Integers in sorted order without duplicates:");
        for (int num : TS) 
        {
            System.out.println(num);
        }

        sc.close();
    }
}

