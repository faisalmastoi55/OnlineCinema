package com.cinema.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.dao.impl.BookingServiceImpl;
import com.cinema.entities.Booking;
import com.cinema.entities.User;
import com.cinema.helper.ConnectionProvider;

@WebServlet("/bookMovie")
public class BookMovieServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int movieId = Integer.parseInt(request.getParameter("movie_id"));
	        int tickets = Integer.parseInt(request.getParameter("tickets"));
	        
	        HttpSession session = request.getSession();
	        User user = (User) session.getAttribute("userObj");

	        Booking booking = new Booking();
	        booking.setUserId(user.getId());
	        booking.setMovieId(movieId);
	        booking.setTickets(tickets);

	        BookingServiceImpl dao = new BookingServiceImpl(ConnectionProvider.getConnection());
	        boolean isBooked = dao.addBooking(booking);

	        if (isBooked) {
	            session.setAttribute("succMsg", "Movie booked successfully!");
	        } else {
	            session.setAttribute("failMsg", "Insufficient tickets available.");
	        }
	        response.sendRedirect("admin/bookMovie.jsp");
		
	}

}
