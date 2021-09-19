package com.rozy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rozy.dao.DB;
import com.rozy.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. Fetch Data in REQUEST: request.getParameter -> will always return String
		User user=new User();
		user.username=request.getParameter("uname");
		user.password=request.getParameter("psw");
		
		// 2. Perform some Logical Operation
		
		DB db = new DB();
		boolean result = db.loginUser(user);				
		
		// 3. Send RESPOSNE to client ->  Either Text or HTML
				response.setContentType("text/html");
				
				PrintWriter writer = response.getWriter();
				
				//String message = "Thank You "+user.name;
				String html = "";
				if(result) {
					
					HttpSession session = request.getSession();
					session.setAttribute("keyUser", user);
					
					RequestDispatcher view = request.getRequestDispatcher("home.jsp");
					view.forward(request, response);
					
//					html = "<html><body><center>THANK YOU "+user.name+"<br>Login Success<br><br>"
//							+ "<a href='home.jsp'>Enter Home</a>"
//							+ "</center></body></html>";
					
				}else {
					html = "<html><body><center>Invalid Credentials"+user.username+"<br>Please try Again</center></body></html>";					
				}
				
				//writer.println(message);
				writer.println(html);
		
		
	}

}
