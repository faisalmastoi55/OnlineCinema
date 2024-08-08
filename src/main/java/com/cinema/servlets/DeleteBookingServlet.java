package com.cinema.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cinema.dao.impl.BookingServiceImpl;
import com.cinema.helper.ConnectionProvider;

@WebServlet("/deleteBooking")
public class DeleteBookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("booking_id"));

        HttpSession session = request.getSession();

        BookingServiceImpl dao = new BookingServiceImpl(ConnectionProvider.getConnection());
        boolean removeBooking = dao.removeBooking(bookingId);

        if (removeBooking) {
            session.setAttribute("succMsg", "Booking deleted successfully");
        } else {
            session.setAttribute("failMsg", "Failed to delete booking");
        }
        response.sendRedirect("admin/showBookings.jsp");
    }
}
