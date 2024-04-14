package pack;

import java.util.TreeSet;

public class Slip16
{
    public static void main(String[] args) 
    {
        // Create a TreeSet to store colors
        TreeSet<String> colorsSet = new TreeSet<>();

        // Add some colors to the TreeSet
        colorsSet.add("Red");
        colorsSet.add("Green");
        colorsSet.add("Blue");
        colorsSet.add("Yellow");
        colorsSet.add("Orange");

        // Print out the content of the TreeSet in ascending order
        System.out.println("Colors in ascending order:");
        for (String color : colorsSet) {
            System.out.println(color);
        }
    }
}
