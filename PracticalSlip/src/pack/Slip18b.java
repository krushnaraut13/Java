package pack;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Slip18b extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from the request
        String seatNo = request.getParameter("seatNo");
        String studName = request.getParameter("studName");
        String studClass = request.getParameter("studClass");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        // Calculate percentage
        double percentage = (totalMarks / 500.0) * 100;

        // Determine grade based on percentage
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Set content type of the response
        response.setContentType("text/html");

        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        // Display student details on the webpage
        out.println("<html><head><title>Student Details</title></head><body>");
        out.println("<h2>Student Details</h2>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Name: " + studName + "</p>");
        out.println("<p>Class: " + studClass + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body></html>");
    }
}
