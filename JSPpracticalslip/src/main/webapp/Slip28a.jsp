<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reverse String</title>
</head>
<body>
    <h1>Reverse String</h1>
   
    <form action="" method="post">
        Enter a string: <input type="text" name="inputString">
        <input type="submit" value="Reverse">
    </form>
    
    <%
        // Retrieve the input string from the form
        String inputString = request.getParameter("inputString");
        
        // Check if the input string is not null and not empty
        if(inputString != null && !inputString.isEmpty()) {
            // Reverse the input string
            String reversedString = new StringBuilder(inputString).reverse().toString();
        
        
    %>
            <p>Reversed string: <%= reversedString %></p>
    <%
    }
    %>

</body>
</html>
