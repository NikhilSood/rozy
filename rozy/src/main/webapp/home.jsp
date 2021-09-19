<%@page import="com.rozy.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rozy</title>

<link href="CSS/imgofcontainer.css" rel="stylesheet" type="text/css"/>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"> -->

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<!-- Latest compiled and minified CSS -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> -->

<!-- jQuery library -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->

<!-- Popper JS -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> -->

<!-- Latest compiled JavaScript -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> -->

<!--   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

	<%
		User user = (User)session.getAttribute("keyUser");
	%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="hn1.png" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Link 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
	   <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        <%=user.name %>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="viewrent.jsp">View Logs</a>
        <a class="dropdown-item" href="profile.jsp">Edit Profile</a>
        <a class="dropdown-item" href="Logout">Logout</a>
      </div>
    </li>



  </ul>
</nav>
	
	<div class="jumbotron" style=" background-image: url(h1.jpg); height:100%; width:100%;">
        <h1 class="text-white">ROZY</h1>
        <h3 class="text-white">Welcome Home, Dear <%= user.name %></h3>
        <h4 class="text-white">Logged in with -> <%= user.username %></h4>
        <p class="text-white">Rozy is the best platform for Rent Management</p>
    </div>
	
	
	<div id="header" class="container-fluid" >
		<center >
		<%-- <h4><%= user.username %></h4> --%>
 	<div class=" jumbotron text-center"  style=" background: rgba(204, 204, 204, 0.2);">
		<form action="addrent.jsp" method="get" >
			<input type="text" name="txtrent" val="eg: 98.4">
			<input type="submit" value="LOG RENT">
		</form>
		
		<h3>Log Your Rent Details Here</h3>
		<a href="viewrent.jsp">VIEW ALL RENT RECORDS</a>
		<br><br>
	 	</div> 
		</center>
	
		
		</div>
		
		</div>
		
		<br>
		<br>
		<br>
		<br>
		
				
</body>
</html>