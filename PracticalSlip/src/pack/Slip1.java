package pack;

public class Slip1
{

    public static void main(String[] args) 
    {
        char currentAlphabet = 'A';
        while (currentAlphabet <= 'Z') 
        {
            System.out.print(currentAlphabet + " ");
            try 
            {
                Thread.sleep(2000); // Sleep for 2 seconds
            }
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            currentAlphabet++;
        }
    }
}
