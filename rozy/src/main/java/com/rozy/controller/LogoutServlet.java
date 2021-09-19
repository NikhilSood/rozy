package com.rozy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet({ "/LogoutServlet", "/Logout" })
public class LogoutServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
//        request.getRequestDispatcher("link.html").include(request, response);  
        String html="";
		 
		 HttpSession session=request.getSession();  
	     session.invalidate(); 
	     
	    html = "<html><head><meta charset=\"utf-8\">\r\n"
	    		+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
	    		+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
	    		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
	    		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
	    		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
	    		+ "</head><body><center>"
	    		+ " 	<div class=\"container\" style=\"margin-top:60px;\">\r\n"
	    		+ "			 <div class=\"alert alert-success alert-dismissible fade show\">\r\n"
	    		+ "	    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\r\n"
	    		+ "	    <strong>Logout Success!</strong> Successfully Logout.\r\n"
	    		+ "	  		</div>\r\n"
	    		+ "		</div>"
			 		
			 	+ "</center></body></html>";
          
        out.print(html); 
        request.getRequestDispatcher("index.html").include(request, response);
          
        out.close(); 
	
	}

}