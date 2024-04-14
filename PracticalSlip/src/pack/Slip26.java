package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Slip26 
{
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) 
    {
        // Check if employee ID is provided as a command line argument
        if (args.length != 1) 
        {
            System.out.println("Usage: java DeleteEmployeeDetails <employeeID>");
            return;
        }

        // Parse the employee ID from the command line argument
        int eno = Integer.parseInt(args[0]);

        Connection con= null;
        PreparedStatement ps = null;

        try {
            // Establishing a connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz", "root", "2024");

            // Deleting the employee details using PreparedStatement
            String deleteQuery = "delete from employee where eno = 1";
            ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, eno);

            // Execute the delete query
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) 
            {
                System.out.println("Employee details deleted successfully.");
            } 
            else 
            {
                System.out.println("No employee found with the provided employee ID.");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        } 
       
        }
    }
