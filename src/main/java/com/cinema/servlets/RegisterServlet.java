package com.cinema.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.dao.impl.UserServiceImpl;
import com.cinema.entities.User;
import com.cinema.helper.ConnectionProvider;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String check = request.getParameter("check");
		
		User user = new User(name, email, phone, password, role);
		
		HttpSession session = request.getSession();
		
		if (check != null) {
			
			UserServiceImpl dao = new UserServiceImpl(ConnectionProvider.getConnection());
			Boolean checkUser = dao.checkUser(email);
			
			if (checkUser) {
				Boolean register = dao.userRegister(user);
				
				if (register) {
					session.setAttribute("succMsg", "'"+role+"' Register Successfully");
					response.sendRedirect("register.jsp");
					
				} else {
					session.setAttribute("failedMsg", "Something wrong on server");
					response.sendRedirect("register.jsp");
				}
			} else {
				session.setAttribute("failedMsg", "User already exist in this email id!! Try another email.......");
				response.sendRedirect("register.jsp");
			}
			
		}else {
			session.setAttribute("failedMsg", "Plz check terms & conditions!!!!");
			response.sendRedirect("register.jsp");
		}
		
	}

}
