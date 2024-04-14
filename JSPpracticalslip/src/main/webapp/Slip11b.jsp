<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
public void doget
    int number = Integer.parseInt(request.getParameter("number"));
    boolean isPerfect = false;

    int sum = 0;
    for (int i = 1; i <= number / 2; i++) 
    {
        if (number % i == 0) 
        {
            sum += i;
        }
    }

    if (sum == number) 
    {
        isPerfect = true;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfect Number Checker</title>
</head>
<body>
    <h2>Perfect Number Checker</h2>
    <p>The number <%= number %> is <%= isPerfect ? "perfect" : "not perfect" %>.</p>
</body>
</html>
