<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Details</title>
</head>
<body>
    <h2>Patient Details</h2>
    <table border="1">
        <tr>
            <th>Patient No</th>
            <th>Name</th>
            <th>Address</th>
            <th>Age</th>
            <th>Disease</th>
        </tr>
        <%
            // Sample patient details, you can replace it with your data source
            String[][] patients =
            {
                {"P1", "Pratik", "A.nagar", "21", "Fever"},
                {"P2", "Kaustubh", "Loni", "21", "Headache"},
                {"P3", "Shubham", "Bhableshar", "21", "Flu"}
            };
            
            // Displaying patient details in the table
            for (String[] patient : patients) 
            {
        %>
        <tr>
            <td><%= patient[0] %></td>
            <td><%= patient[1] %></td>
            <td><%= patient[2] %></td>
            <td><%= patient[3] %></td>
            <td><%= patient[4] %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
