package com.cinema.entities;

import java.sql.Timestamp;

public class Booking {
    private int bookingId;
    private int userId;
    private int movieId;
    private Timestamp bookingDate;
    private int tickets;
    private String movieTitle;

    public Booking() {
    }

    public Booking(int userId, int movieId, int tickets, String movieTitle) {
        this.userId = userId;
        this.movieId = movieId;
        this.tickets = tickets;
        this.movieTitle = movieTitle;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    
}
