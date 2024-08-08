package com.cinema.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.dao.impl.MovieServiceImpl;
import com.cinema.entities.Movie;
import com.cinema.helper.ConnectionProvider;

@WebServlet("/updateMovie")
public class UpdateMovieServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("movie_id"));
			String title = request.getParameter("title");
			String date = request.getParameter("release_date");
			String descriptio = request.getParameter("descriptio");
			int tickets = Integer.parseInt(request.getParameter("tickets"));
			String statuss = request.getParameter("statuss");
			
			Movie movie = new Movie();
			movie.setMovie_id(id);
			movie.setTitle(title);
			movie.setRelease_date(date);
			movie.setDescriptio(descriptio);
			movie.setTickets(tickets);
			movie.setStatuss(statuss);
			
			MovieServiceImpl dao = new MovieServiceImpl(ConnectionProvider.getConnection());
			Boolean updateMovie = dao.updateMovie(movie);
			
			HttpSession s = request.getSession();
			
			if(updateMovie) {
				s.setAttribute("succMsg", "Movie Updated Successfully...");
				response.sendRedirect("admin/showMovies.jsp");
			} else {
				s.setAttribute("failMsg", "Something wrong on server...");
				response.sendRedirect("admin/showMovies.jsp");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
