package pack;

import java.util.Random;

class NumberGenerator extends Thread {
    public void run() {
        Random rand = new Random();
        while (true) {
            int num = rand.nextInt(100); // Generate random integer between 0 and 99
            System.out.println("Generated Number: " + num);
            if (num % 2 == 0) {
                EvenThread.square(num);
            } else {
                OddThread.cube(num);
            }
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenThread extends Thread
{
    public static void square(int num) 
    {
        System.out.println("Square of " + num + ": " + (num * num));
    }
}

class OddThread extends Thread 
{
    public static void cube(int num) 
    {
        System.out.println("Cube of " + num + ": " + (num * num * num));
    }
}

public class Slip7b
{
    public static void main(String[] args) 
    {
        NumberGenerator generator = new NumberGenerator();
        generator.start();
    }
}
