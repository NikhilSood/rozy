package com.rozy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rozy.dao.DB;
import com.rozy.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet( "/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. Fetch data from Request
		User user = new User();
		user.name = request.getParameter("name");
//		user.setName(request.getParameter("txtName"));
		user.username = request.getParameter("username");
		user.password = request.getParameter("password");
		//user.makePasswordSecure();
		
		System.out.println("user detail is : "+user);
		
		// 2. Logical Processing
		DB db=new DB();
		
		// 3. Send Back some Response
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean result = db.registerUser(user);
		
		String html = "";
		
		if(result) {
			
			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
			view.forward(request, response);
			
//			html = "<html><body><center>THANK YOU "+user.username+"<br>Registration Success<br><br>"
//					+ "<a href='home.jsp'>Enter Home</a>"
//					+ "</center></body></html>";
		}else {
			html = "<html><body><center>Somthing Went Wrong"+user.username+"<br>Please try Again</center></body></html>";

		}
		
		out.println(html);		
		
		
	}

}
