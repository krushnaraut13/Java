<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prime Number Checker</title>
</head>
<body>
    <h2>Prime Number Checker</h2>
    
    <%
        int number = Integer.parseInt(request.getParameter("number"));
        boolean isPrime = true;

        if (number <= 1) 
        {
            isPrime = false;
        } 
        else 
        {
            for (int i = 2; i <= Math.sqrt(number); i++)
            {
                if (number % i == 0) 
                {
                    isPrime = false;
                    break;
                }
            }
        }
        
        String rc=isPrime ? "red":"black";
    %>
    
<p style="color: <%=rc %>;"> <%=number %> is <%=isPrime ? "prime":"NotPrime"%>
</body>
</html>
