package pack;

import java.util.Hashtable;
import java.util.Enumeration;

public class Slip5 
{
    public static void main(String[] args) 
    {
        Hashtable<String, String> HS = new Hashtable<>();

        // Adding student details to the hash table
        HS.put("Krishna", "1234567890");
        HS.put("Pratik", "9876543210");
        HS.put("Kaustubh","0123456789");

        // Displaying student details using Enumeration
        Enumeration<String> enu = HS.keys();
        System.out.println("Student Details:");
        while (enu.hasMoreElements())
        {
            String studentName = enu.nextElement();
            String mobileNumber = HS.get(studentName);
            System.out.println("Name: " + studentName);
            System.out.println("Mobile Number: " + mobileNumber);
        }
    }
}
