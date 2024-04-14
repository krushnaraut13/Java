package pack;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Slip2b extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        // Setting the response content type
        response.setContentType("text/html");

        // Getting the client's IP address
        String ipAddress = request.getRemoteAddr();

        // Getting the browser type
        String browserType = request.getHeader("User-Agent");

        // Getting the server information
        String serverInfo = getServletContext().getServerInfo();

        // Getting the names of currently loaded servlets
        Enumeration<String> servletNames = getServletContext().getServletNames();
        StringBuilder loadedServlets = new StringBuilder();
        while (servletNames.hasMoreElements()) {
            loadedServlets.append(servletNames.nextElement()).append("<br>");
        }

        // Creating HTML response content
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Request Information</title></head><body>");
        out.println("<h2>Client Information:</h2>");
        out.println("<p>IP Address: " + ipAddress + "</p>");
        out.println("<p>Browser Type: " + browserType + "</p>");
        out.println("<h2>Server Information:</h2>");
        out.println("<p>Server Info: " + serverInfo + "</p>");
        out.println("<p>Loaded Servlets: <br>" + loadedServlets.toString() + "</p>");
        out.println("</body></html>");
    }
}
