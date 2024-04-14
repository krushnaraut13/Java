package pack;


import java.sql.*;

public class Slip16b {
    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    //static final String USER = "your_username";
    //static final String PASS = "your_password";

    public static void main(String[] args) 
    {
        try
        {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xyz","root","2024");

            // Create table if not exists
            String createTableSQL = "create table teacher(tno int, tname varchar(255), subject varchar(255))";
            PreparedStatement pstmt = conn.prepareStatement(createTableSQL);
            pstmt.executeUpdate();

            // Insert records PreparedStatement 
            String insertSQL = "insert into teacher values (?, ?, ?)";
             pstmt = conn.prepareStatement(insertSQL);
            
            pstmt.setInt(1, 1);
            pstmt.setString(2, "John Doe");
            pstmt.setString(3, "JAVA");
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setString(2, "Alice Smith");
            pstmt.setString(3, "C++");
            pstmt.executeUpdate();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Bob Johnson");
            pstmt.setString(3, "JAVA");
            pstmt.executeUpdate();

            pstmt.setInt(1, 4);
            pstmt.setString(2, "Emma Brown");
            pstmt.setString(3, "Python");
            pstmt.executeUpdate();

            pstmt.setInt(1, 5);
            pstmt.setString(2, "Michael Wilson");
            pstmt.setString(3, "JAVA");
            pstmt.executeUpdate();

            // Display details of teachers teaching "JAVA" subject
            String selectSQL = "select * from teacher where subject= ?";
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setString(1, "JAVA");
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Teachers teaching JAVA:");
            while (rs.next()) 
            {
                int tNo = rs.getInt("TNo");
                String tName = rs.getString("TName");
                String subject = rs.getString("Subject");
                System.out.println("Teacher No: " + tNo + ", Name: " + tName + ", Subject: " + subject);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } 
        catch (SQLException se) 
        {
            se.printStackTrace();
        } 
    
    }
}
