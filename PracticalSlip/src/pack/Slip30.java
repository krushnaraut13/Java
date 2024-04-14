package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Slip30 
{

    public static void main(String[] args) 
    {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try 
        {
            // Establishing a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz", "root", "2024");

            // Creating a statement object with scrollable ResultSet
            Statement st =conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Executing a query to retrieve data from Teacher table
            ResultSet rs = st.executeQuery("select * from teacher");

            // Moving the cursor to the last row of the ResultSet
            rs.last();

            // Getting the total number of rows in the ResultSet
            int rowCount = rs.getRow();

            // Displaying the total number of rows
            System.out.println("Total number of rows in Teacher table: " + rowCount);

            // Moving the cursor to the first row of the ResultSet
            rs.beforeFirst();

            // Iterating through the ResultSet and displaying the data
            while (rs.next()) 
            {
                int tid = rs.getInt("TID");
                String tname = rs.getString("TName");
                double salary = rs.getDouble("Salary");
                System.out.println("TID: " + tid + ", TName: " + tname + ", Salary: " + salary);
            }

            // Closing the resources
            rs.close();
            st.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
