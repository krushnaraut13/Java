<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Number to Words</title>
</head>
<body>
    <h1>Number to Words</h1>
    
    <%-- Java code to convert number to words --%>
    <%
        // Function to convert a digit to its corresponding word
        String digitToWord(int digit) 
    {
            switch (digit) 
            {
                case 0: return "Zero";
                case 1: return "One";
                case 2: return "Two";
                case 3: return "Three";
                case 4: return "Four";
                case 5: return "Five";
                case 6: return "Six";
                case 7: return "Seven";
                case 8: return "Eight";
                case 9: return "Nine";
                default: return ""; // Return empty string for invalid digits
            }
        }

        // Retrieve the number from the request parameter
        String numberParam = request.getParameter("number");
        
        // Check if the parameter is not null and not empty
        if (numberParam != null && !numberParam.isEmpty())
        {
            // Convert the number parameter to an integer
            int number = Integer.parseInt(numberParam);
            
            // Convert each digit of the number to words
            String words = "";
            while (number > 0) 
            {
                int digit = number % 10;
                words = digitToWord(digit) + " " + words;
                number /= 10;
            }
    %>
            <%-- Displaying the number in words in red color --%>
            <p style="color:red;"><%= words.trim() %></p>
    <%
        }
    %>
    
    <%-- Input form --%>
    <form action="" method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Convert">
    </form>
</body>
</html>
