<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h1>Sum of First and Last Digit</h1>
    
    <%
        // Function to calculate the sum of first and last digits
        int calculateSum(int number) 
    {
            int lastDigit = number % 10;
            while (number >= 10) 
            {
                number /= 10;
            }
            return number + lastDigit;
        }

        // Retrieve the number from the request parameter
        String numberParam = request.getParameter("number");
        
        // Check if the parameter is not null and not empty
        if (numberParam != null && !numberParam.isEmpty()) {
            // Parse the number parameter to an integer
            int number = Integer.parseInt(numberParam);
            
            // Calculate the sum of first and last digits
            int sum = calculateSum(number);
    %>
<p style="color:red; font-size:18px;">Sum of first and last digit: <%= sSum %></p>
    <%
        }
    %>
    
    
    <form action="" method="post">
        Enter a number: 
        <input type="text" name="number">
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
