package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.User.UserDetails;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String uemail=request.getParameter("uemail");
		String upassword=request.getParameter("upassword");
		
		UserDetails userDetails=new UserDetails();
		userDetails.setName(uname);
		userDetails.setEmail(uemail);
		userDetails.setPassword(upassword);
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		boolean f=dao.addUser(userDetails);
		
		
		if(f) {
			HttpSession session=request.getSession();
			session.setAttribute("reg-success","Registration successful");
			response.sendRedirect("register.jsp");
			
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("failed-msg","Something went wrong");
			response.sendRedirect("register.jsp");
			
		}
		
		
	}

}
