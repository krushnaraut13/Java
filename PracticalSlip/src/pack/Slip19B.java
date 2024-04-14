package pack;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Change to your database URL
        String dbUsername = "your_username"; // Change to your username
        String dbPassword = "your_password"; // Change to your password
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Establish database connection
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Prepare SQL statement
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the query
            rs = pstmt.executeQuery();

            // Check if the user exists in the database
            if (rs.next()) {
                // User found, display success message
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><head><title>Login Result</title></head><body>");
                out.println("<h2>Login Successful</h2>");
                out.println("<p>Welcome, " + username + "!</p>");
                out.println("</body></html>");
            } else {
                // User not found, display error message
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><head><title>Login Result</title></head><body>");
                out.println("<h2>Login Failed</h2>");
                out.println("<p>Invalid username or password.</p>");
                out.println("</body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
