<%@page import="java.util.ArrayList"%>
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

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  
</head>
<body>

	<%
		User user = (User)session.getAttribute("keyUser");
		DB db = new DB();
	%>
	
	<div class="container">
  <h2>Rent Record</h2>
  <p>Dear <%= user.name%>, your rent records till date: </p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Date Time</th>
        <th>Fever</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
   	   <%
   	        ArrayList<Rent> rents = db.fetchrent(user._id);
		
			for(Rent rent : rents){
				
		%>
    
	      <tr>
	        <td><%= rent.datetime %></td>
	        <td><%= rent.rent %></td>
	         <td><a href='action.jsp?action=update&rent_id=<%=rent._id%>&rent=<%=rent.rent%>'>UPDATE</a>  <a href='action.jsp?action=delete&rent_id=<%=rent._id%>'>DELETE</a></td>
	      </tr>
	      
      	<%			
				
			}
		%>
    </tbody>
  </table>
</div>	

</body>
</html>