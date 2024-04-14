package pack;

import java.sql.*;
import java.util.Scanner;

public class Slip22 
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/your_database"; // Change 'your_database' to your database name
    static final String USER = "your_username"; // Change 'your_username' to your database username
    static final String PASS = "your_password"; // Change 'your_password' to your database password

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz","root","2024");

            // Create a statement
            stmt = con.createStatement();

            // Create Employee table if not exists
            createEmployeeTable(stmt);

            Scanner sc = new Scanner(System.in);

            // Main menu
            while (true) 
            {
                System.out.println("\nMenu:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) 
                {
                    case 1:
                        insertEmployee(sc, stmt);
                        break;
                    case 2:
                        updateEmployee(sc, stmt);
                        break;
                    case 3:
                        displayEmployees(stmt);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        sc.close();
                        stmt.close();
                        conn.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
        catch (SQLException se) 
        {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e) 
        {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    // Method to create Employee table
    private static void createEmployeeTable(Statement stmt) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee (" +
                "ENo INT PRIMARY KEY," +
                "EName VARCHAR(50)," +
                "Salary DOUBLE" +
                ")";
        stmt.executeUpdate(createTableSQL);
    }

    // Method to insert employee into Employee table
    private static void insertEmployee(Scanner scanner, Statement stmt) throws SQLException {
        System.out.print("Enter Employee Number: ");
        int eno = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String ename = scanner.next();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        String insertQuery = "INSERT INTO Employee (ENo, EName, Salary) VALUES (" + eno + ", '" + ename + "', " + salary + ")";
        int rowsAffected = stmt.executeUpdate(insertQuery);
        if (rowsAffected > 0)
        {
            System.out.println("Employee inserted successfully.");
        } else 
        {
            System.out.println("Failed to insert employee.");
        }
    }

    // Method to update employee salary in Employee table
    private static void updateEmployee(Scanner scanner, Statement stmt) throws SQLException {
        System.out.print("Enter Employee Number: ");
        int eno = scanner.nextInt();
        System.out.print("Enter new Salary: ");
        double salary = scanner.nextDouble();

        String updateQuery = "UPDATE Employee SET Salary = " + salary + " WHERE ENo = " + eno;
        int rowsAffected = stmt.executeUpdate(updateQuery);
        if (rowsAffected > 0) 
        {
            System.out.println("Employee salary updated successfully.");
        } else
        {
            System.out.println("Failed to update employee salary.");
        }
    }

    // Method to display all employees in Employee table
    private static void displayEmployees(Statement stmt) throws SQLException {
        String selectQuery = "SELECT * FROM Employee";
        ResultSet rs = stmt.executeQuery(selectQuery);

        System.out.println("\nEmployee Details:");
        System.out.println("ENo\tEName\tSalary");
        while (rs.next()) 
        {
            int eno = rs.getInt("ENo");
            String ename = rs.getString("EName");
            double salary = rs.getDouble("Salary");
            System.out.println(eno + "\t" + ename + "\t" + salary);
        }
        rs.close();
    }
}
