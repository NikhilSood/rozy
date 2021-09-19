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

	<center>

	<%
		DB db = new DB();
	
		String action = request.getParameter("action");
		String rent_id = request.getParameter("rent_id");
		String rent = request.getParameter("rent");
		
		if(action.equals("delete")){
			// delete the fever record
			db.deleteRent(rent_id);
	%>
			<h3>Rent Record Deleted</h3>
	<%			
		}else{
			
	%>	
		<h3>UPDATE FEVER</h3>	
		<form action="update.jsp" method="get">
			<input type="text" name="txtrent" value="<%=rent%>">
			<input type="hidden" name="txtrent_id" value="<%=rent_id%>">
			<input type="submit" value="UPDATE RENT">
		</form>
	<%			// update the fever record
		}
	%>
	</center>

</body>
</html>