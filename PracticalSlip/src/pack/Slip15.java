package pack;

public class Slip15 
{
    public static void main(String[] args) 
    {
        // Create a thread object
        Thread thread = new Thread();
        
        // Display name and priority of the thread
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
    }
}
