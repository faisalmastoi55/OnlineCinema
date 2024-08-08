package com.cinema.dao;

import java.util.List;

import com.cinema.entities.Booking;

public interface BookingService {

	Boolean addBooking(Booking booking);
	
	List<Booking> getBookingsByUserId(int userId);
	
	Boolean updateMovieTickets(int movieId, int bookedTickets);
	
	boolean removeBooking(int bookingId) ;
}
