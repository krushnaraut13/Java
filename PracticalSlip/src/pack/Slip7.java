package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Slip7 
{
    // Database connection parameters
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/your_database";

    // Database credentials
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) 
    {
        Connection conn = null;
        Statement stmt = null;
        try 
        {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz", "root", "2024");

            // Execute a query to create the Product table
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE Product " +
                    "(Pid INTEGER not NULL, " +
                    " Pname VARCHAR(255), " +
                    " Price DOUBLE, " +
                    " PRIMARY KEY ( Pid ))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully...");

            // Insert records into the table
            System.out.println("Inserting records into the table...");
            sql = "INSERT INTO Product VALUES (101, 'Product1', 10.5)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Product VALUES (102, 'Product2', 20.25)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Product VALUES (103, 'Product3', 15.75)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Product VALUES (104, 'Product4', 30.0)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Product VALUES (105, 'Product5', 25.50)";
            stmt.executeUpdate(sql);
            System.out.println("Records inserted successfully...");

            // Display all records from the table
            System.out.println("Displaying all records from the table...");
            sql = "SELECT * FROM Product";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt("Pid");
                String pname = rs.getString("Pname");
                double price = rs.getDouble("Price");

                // Displaying records
                System.out.println("Pid: " + pid + ", Pname: " + pname + ", Price: " + price);
            }
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // Nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
