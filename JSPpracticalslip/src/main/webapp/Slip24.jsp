<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Result</title>
</head>
<body>
<%
    String username = request.getParameter("krishna");
    String password = request.getParameter("krishna");

    // Check if username and password match
    if (username != null && password != null && username.equals(password)) 
    {
        response.sendRedirect("Login24.html");
    } 
    else 
    {
        response.sendRedirect("Error24.html");
    }
%>
</body>
</html>
