package pack;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionTimeoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the session
        HttpSession session = request.getSession();

        // Set the inactive interval to 60 seconds (1 minute)
        session.setMaxInactiveInterval(60);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Session Timeout Changed</title></head><body>");
        out.println("<h2>Session Timeout Changed</h2>");
        out.println("<p>The inactive time interval of the session has been set to 60 seconds.</p>");
        out.println("</body></html>");
    }
}
