package pack;

class PrintThread extends Thread
{
    private String text;
    private int times;

    public PrintThread(String text, int times) 
    {
        this.text = text;
        this.times = times;
    }

    @Override
    public void run() 
    {
        for (int i = 0; i < times; i++) 
        {
            System.out.println(text);
        }
    }
}

public class Slip8
{
    public static void main(String[] args) 
    {
        Thread t1 = new PrintThread("COVID19", 10);
        Thread t2 = new PrintThread("LOCKDOWN2020", 20);
        Thread t3 = new PrintThread("VACCINATED2021", 30);

        t1.start();
        t2.start();
        t3.start();
    }
}
