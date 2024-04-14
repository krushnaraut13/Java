package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.*;

public class Slip11b extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Retrieve customer number from the request
        String customerNumber = request.getParameter("customerNumber");

        // Perform database search
        String customerDetails = searchCustomer(customerNumber);

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Search Result</title></head><body>");
        
        if (customerDetails != null) {
            out.println("<h2>Customer Details:</h2>");
            out.println("<p>" + customerDetails + "</p>");
        } else {
            out.println("<h2>Error:</h2>");
            out.println("<p>Customer not found.</p>");
        }

        out.println("</body></html>");
    }

    private String searchCustomer(String customerNumber) {
        String customerDetails = null;
        try {
            // Establish database connection and perform query
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");
            String query = "SELECT * FROM customer WHERE customer_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, customerNumber);
            ResultSet rs = pstmt.executeQuery();

            // If customer found, retrieve details
            if (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                // You can retrieve other customer details similarly

                customerDetails = "Customer Number: " + customerNumber + "<br>"
                                + "Name: " + name + "<br>"
                                + "Address: " + address; // Add other details as needed
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerDetails;
    }
}
