<%@page import="com.rozy.model.Rent"%>
<%@page import="com.rozy.dao.DB"%>
<%@page import="com.rozy.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		User user = (User)session.getAttribute("keyUser");
	%>

	<center>
		<h4>Welcome to Rent Management</h4> 
		<b><%= user.name %></b>
	

	<%
		
		Rent rent = new Rent();
	    rent.id = user._id;
		rent.rent = Double.parseDouble(request.getParameter("txtrent"));
		
		DB db = new DB();
		db.logRent(rent);
		
	%>
	
	<p>Your Rent has been Recorded Successfully: <%= rent.rent %></p>
	
	
	
	</center>

</body>
</html>