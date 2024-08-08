package com.cinema.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cinema.dao.BookingService;
import com.cinema.entities.Booking;
import com.cinema.helper.ConnectionProvider;

public class BookingServiceImpl implements BookingService {

	private Connection con;

	public BookingServiceImpl(Connection con) {
		super();
		this.con = con;
	}
	
	public Boolean addBooking(Booking booking) {
        Boolean result = false;
        try {
        	
        	String query = "SELECT tickets FROM movie WHERE movie_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, booking.getMovieId());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int availableTickets = rs.getInt("tickets");
                if (availableTickets < booking.getTickets()) {
                    return false;
                }
            } else {
                return false;
            }
        	
        	con.setAutoCommit(false);
        	
            query = "INSERT INTO bookings(user_id, movie_id, tickets) VALUES(?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getMovieId());
            ps.setInt(3, booking.getTickets());
            int i = ps.executeUpdate();
            if (i > 0) {
                result = updateMovieTickets(booking.getMovieId(), -booking.getTickets());
                
                if (result) {
					con.commit();
				} else {
					con.rollback();
				}
            }
        }  catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (Exception rollbackException) {
                rollbackException.printStackTrace();
            }
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
	
	public List<Booking> getBookingsByUserId(int userId) {
        List<Booking> list = new ArrayList<>();
        try {
            String query = "SELECT b.booking_id, b.user_id, b.movie_id, b.booking_date, b.tickets, m.title FROM bookings b JOIN movie m ON b.movie_id = m.movie_id WHERE b.user_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setUserId(rs.getInt("user_id"));
                booking.setMovieId(rs.getInt("movie_id"));
                booking.setBookingDate(rs.getTimestamp("booking_date"));
                booking.setTickets(rs.getInt("tickets"));
                booking.setMovieTitle(rs.getString("title"));
                list.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

	@Override
	public Boolean updateMovieTickets(int movieId, int bookedTickets) {
		Boolean f = false;
		
		try {
			
			String query = "update movie set tickets = tickets + ? where movie_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bookedTickets);
			ps.setInt(2, movieId);
			int i = ps.executeUpdate();
			if(i > 0) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean removeBooking(int bookingId) {
        boolean result = false;
        try {
            con.setAutoCommit(false);

            String query = "SELECT movie_id, tickets FROM bookings WHERE booking_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bookingId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int movieId = rs.getInt("movie_id");
                int tickets = rs.getInt("tickets");

                query = "DELETE FROM bookings WHERE booking_id = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, bookingId);
                int i = ps.executeUpdate();

                if (i > 0) {
                    result = updateMovieTickets(movieId, tickets);
                    if (result) {
                        con.commit();
                    } else {
                        con.rollback();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (Exception rollbackException) {
                rollbackException.printStackTrace();
            }
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
	
	
}
