<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voter Eligibility Result</title>
</head>
<body>
<%
    // Retrieve form parameters
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));

    // Check eligibility
    String abc = "";
    if (age >= 18) 
    {
        abc = "Congratulations, " + name + "! You are eligible to vote.";
    } 
    else 
    {
        abc = "Sorry, " + name + ". You are not eligible to vote yet. You must be at least 18 years old.";
    }
%>
    <h2>Voter Eligibility Result</h2>
    <p><%= abc %></p>
</body>
</html>
