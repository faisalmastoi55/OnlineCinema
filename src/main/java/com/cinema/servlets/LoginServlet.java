package com.cinema.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.dao.impl.UserServiceImpl;
import com.cinema.entities.User;
import com.cinema.helper.ConnectionProvider;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			UserServiceImpl dao = new UserServiceImpl(ConnectionProvider.getConnection());
			HttpSession session = request.getSession();
			
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			String roleAdmin = "ADMIN";
	        String roleUser = "USER";
			
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setRole(roleAdmin);
			
			
			User login = dao.login(email, password);
			
			
			
			if (login != null && login.getRole().equals(roleAdmin)) {
	            session.setAttribute("userObj", login);
	            response.sendRedirect("admin/adminHome.jsp");
	        } else if (login != null && login.getRole().equals(roleUser)) {
	            session.setAttribute("userObj", login);
	            response.sendRedirect("userHome.jsp");
	        } else {
	            session.setAttribute("failedMsg", "Invalid user & password");
	            response.sendRedirect("login.jsp");
	        }
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
