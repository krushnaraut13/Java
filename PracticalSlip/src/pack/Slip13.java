package pack;

import java.util.Random;

public class Slip13 extends Thread 
{
    private String threadName;

    public Slip13 (String threadName) 
    {
        this.threadName = threadName;
    }

    @Override
    public void run() 
    {
        Random random = new Random();
        int sleepTime = random.nextInt(5000); // Random sleep time between 0 and 4999 milliseconds
        System.out.println(threadName + " is created with sleep time: " + sleepTime + " milliseconds");

        try 
        {
            Thread.sleep(sleepTime); // Thread sleeps for random sleep time
            System.out.println(threadName + " is awake after sleeping for " + sleepTime + " milliseconds");
        } 
        catch (InterruptedException e) 
        {
            System.out.println(threadName + " was interrupted while sleeping.");
        }

        System.out.println(threadName + " is dead");
    }

    public static void main(String[] args) {
    	Slip13 t1 = new Slip13("Thread 1");
    	Slip13 t2 = new Slip13("Thread 2");
    	Slip13 t3 = new Slip13("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
