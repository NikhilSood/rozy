<%@page import="com.rozy.dao.DB"%>
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
		DB db = new DB();
	
		
		String rent_id = request.getParameter("txtrent_id");
		double rent = Double.parseDouble(request.getParameter("txtrent"));
		
		try{
			db.updateRent(rent, rent_id);	
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		 %>
		 <center>
		 <h3>Rent Record Updated</h3>
		 </center>
		<% 
		
	
	%>

</body>
</html>