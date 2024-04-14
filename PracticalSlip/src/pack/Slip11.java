package pack;

import java.sql.*;

public class Slip11
{
    public static void main(String[] args) 
    {
        // JDBC URL, username, and password
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        // SQL query to retrieve metadata
        String query = "select * from doner";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz","root","2024");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) 
        {

            ResultSetMetaData metaData = resultSet.getMetaData();

            // Display column information
            int columnCount = metaData.getColumnCount();
            System.out.println("Column Information for DONAR table:");
            for (int i = 1; i <= columnCount; i++)
            {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Data Type: " + metaData.getColumnTypeName(i));
                System.out.println("Nullable: " + (metaData.isNullable(i) == ResultSetMetaData.columnNullable ? "Yes" : "No"));
                System.out.println("Auto Increment: " + (metaData.isAutoIncrement(i) ? "Yes" : "No"));
                System.out.println();
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
