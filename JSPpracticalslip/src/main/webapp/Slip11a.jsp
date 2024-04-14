<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
    <h1>Main Page</h1>
    <form action="Slip11b.jsp" method="get">
        Enter a number: 
        <input type="text" name="number">
        <input type="submit" value="Check">
    </form>
    
    <%@ include file="Slip11b.jsp" %>
</body>
</html>

