package com.cinema.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.dao.impl.MovieServiceImpl;
import com.cinema.helper.ConnectionProvider;

@WebServlet("/delete_movie")
public class DeleteMovieServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		
		MovieServiceImpl dao = new MovieServiceImpl(ConnectionProvider.getConnection());
		String photoFileName = dao.getPhotoByMovieId(id);
		Boolean deleteMovie = dao.deleteMovie(id);
		
		if (deleteMovie) {
			String path = getServletContext().getRealPath("") + "img" + File.separator + photoFileName;
			File file = new File(path);
			if (file.exists()) {
				file.delete();
			}
			
			session.setAttribute("succMsg", "Movie deleted successfully");
			
		} else {
			session.setAttribute("failedMsg", "Failed to delete movie");
		}
		response.sendRedirect("admin/showMovies.jsp");
	}

}
