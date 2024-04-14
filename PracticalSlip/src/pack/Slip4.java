package pack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Slip4 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        HashMap<String, Integer> HS = new HashMap<>();

        while (true) 
        {
            System.out.println("\n1. Add a new city and its code");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city name and display the code");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) 
            {
                case 1:
                    System.out.print("Enter city name: ");
                    String city = sc.nextLine();
                    System.out.print("Enter STD code: ");
                    int stdCode = sc.nextInt();
                    if (!HS.containsKey(city)) 
                    {
                        HS.put(city, stdCode);
                        System.out.println("City added successfully.");
                    } else 
                    {
                        System.out.println("City already exists.");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter city name to remove: ");
                    String cityToRemove = sc.nextLine();
                    if (HS.containsKey(cityToRemove)) 
                    {
                        HS.remove(cityToRemove);
                        System.out.println("City removed successfully.");
                    } else 
                    {
                        System.out.println("City not found.");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter city name to search: ");
                    String searchCity = sc.nextLine();
                    if (HS.containsKey(searchCity)) 
                    {
                        System.out.println("STD code for " + searchCity + ": " + HS.get(searchCity));
                    } else 
                    {
                        System.out.println("City not found.");
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
