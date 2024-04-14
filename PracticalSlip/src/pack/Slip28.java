package pack;

public class Slip28 
{

    public static void main(String[] args) 
    {
        // Creating multiple threads
        Thread th1 = new Thread(new MyRunnable(), "Thread 1");
        Thread th2 = new Thread(new MyRunnable(), "Thread 2");

        // Starting the threads
        th1.start();
        th2.start();

        // Getting and displaying the name of the currently executing thread
        System.out.println("Main thread is executing: " + Thread.currentThread().getName());
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // Getting and displaying the name of the currently executing thread
            System.out.println("Current thread is executing: " + Thread.currentThread().getName());
        }
    }
}
