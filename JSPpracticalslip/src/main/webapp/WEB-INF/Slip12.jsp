<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" <%@ include file="checkPerfectNumberLogic.jsp" %>%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
            int number = Integer.parseInt(request.getParameter("number"));
            boolean isPerfect = checkPerfectNumber(number);
            out.println("Number " + number + " is " + (isPerfect ? "perfect" : "not perfect"));
        %>
        <%
    boolean checkPerfectNumber(int number) {
        int sum = 1; // 1 is a divisor of every number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i == (number / i)) {
                    sum += i;
                } else {
                    sum += (i + number / i);
                }
            }
        }
        if (sum == number && number != 1) {
            return true;
        } else {
            return false;
        }
    }
%>
</body>
</html>