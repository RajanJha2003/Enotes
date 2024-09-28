package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.User.UserDetails;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uemail=request.getParameter("uemail");
		String upassword=request.getParameter("upassword");
		
		UserDetails userDetails=new UserDetails();
		userDetails.setEmail(uemail);
		userDetails.setPassword(upassword);
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		boolean f=dao.loginUser(userDetails);
		
		
		if(f) {
			response.sendRedirect("home.jsp");
			
		}else {
			
			
		}
		
		
	}

}
