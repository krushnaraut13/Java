package pack;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Slip15b extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the current session
        HttpSession session = request.getSession();

        // Get the visit count from the session
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        // If visitCount is null, this is the first visit
        if (visitCount == null) {
            visitCount = 1;
            session.setAttribute("visitCount", visitCount);
            response.getWriter().println("Welcome! This is your first visit.");
        } else {
            // Increment the visit count
            visitCount++;
            session.setAttribute("visitCount", visitCount);
            response.getWriter().println("Welcome back! You have visited this page " + visitCount + " times.");
        }
    }
}
