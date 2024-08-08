<%@page import="java.util.List"%>
<%@page import="com.cinema.entities.User"%>
<%@page import="com.cinema.entities.Booking"%>
<%@page import="com.cinema.helper.ConnectionProvider"%>
<%@page import="com.cinema.dao.impl.BookingServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Bookings</title>
<%@include file="allCss.jsp" %>
</head>
<body>

<%@include file="navbar.jsp" %>

<div class="container">
    <h5 class="text-center fw-bold py-3">Your Bookings</h5>
    <c:if test="${not empty succMsg}">
        <h5 class="text-center text-success">${succMsg}</h5>
        <c:remove var="succMsg" scope="session" />
    </c:if>
    <c:if test="${not empty failMsg}">
        <h5 class="text-center text-danger">${failMsg}</h5>
        <c:remove var="failMsg" scope="session" />
    </c:if>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">Booking ID</th>
                <th scope="col">Movie ID</th>
                    <th scope="col">Movie Title</th>
                <th scope="col">Tickets</th>
                <th scope="col">Booking Date</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
                HttpSession s = request.getSession();
                User user = (User) s.getAttribute("userObj");
                BookingServiceImpl dao = new BookingServiceImpl(ConnectionProvider.getConnection());
                List<Booking> bookings = dao.getBookingsByUserId(user.getId());
                for (Booking b : bookings) {
            %>
            <tr>
                <td><%= b.getBookingId() %></td>
                <td><%= b.getMovieId() %></td>
                <td><%= b.getMovieTitle() %></td>
                <td><%= b.getTickets() %></td>
                <td><%= b.getBookingDate() %></td>
                <td>
                    <a href="../deleteBooking?booking_id=<%= b.getBookingId() %>" class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Remove</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
