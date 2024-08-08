package com.cinema.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.cinema.dao.impl.MovieServiceImpl;
import com.cinema.entities.Movie;
import com.cinema.entities.User;
import com.cinema.helper.ConnectionProvider;

@WebServlet("/addMovie")
@MultipartConfig
public class AddMovieServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String title = request.getParameter("title");
			String date = request.getParameter("release_date");
			String descriptio = request.getParameter("descriptio");
			int tickets = Integer.parseInt(request.getParameter("tickets"));
			String statuss = request.getParameter("statuss");
			Part photo = request.getPart("photo");
			String fileName = photo.getSubmittedFileName();
			
			//current id user
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("userObj");
			
			Movie movie = new Movie(title, date, null, descriptio, tickets, statuss, fileName, user.getId());
			
			MovieServiceImpl dao = new MovieServiceImpl(ConnectionProvider.getConnection());
			
			
			Boolean movie2 = dao.addMovie(movie);
			if (movie2) {
				String path = getServletContext().getRealPath("") + "img";
				System.out.println(path);
				File file = new File(path);
				photo.write(path + File.separator + fileName);
				
				session.setAttribute("succMsg", "Movie added Successfully");
				response.sendRedirect("admin/addMovie.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on server");
				response.sendRedirect("admin/addMovie.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
