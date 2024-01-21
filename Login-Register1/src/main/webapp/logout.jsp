<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lagout page</title>
</head>
<body>
<%
HttpSession currentsession1 = request.getSession(false);
            // Redirect to the login page if the session is not valid
            if(currentsession1!=null){
            	currentsession1.invalidate();
            }
            response.sendRedirect("index.html");
        
   %>
</body>
</html>