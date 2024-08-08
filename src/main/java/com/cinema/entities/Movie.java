package com.cinema.entities;

import java.sql.Timestamp;

public class Movie {

	private int movie_id;
	private String title;
	private String release_date;
	private Timestamp add_date;
	private String descriptio;
	private int tickets;
	private String statuss;
	private String photo;
	private int id;
	public Movie(int movie_id, String title, String release_date, Timestamp add_date, String descriptio, int tickets,
			String statuss, String photo, int id) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.release_date = release_date;
		this.add_date = add_date;
		this.descriptio = descriptio;
		this.tickets = tickets;
		this.statuss = statuss;
		this.photo = photo;
		this.id = id;
	}
	public Movie() {
		super();
	}
	public Movie(String title, String release_date, Timestamp add_date, String descriptio, int tickets, String statuss,
			String photo, int id) {
		super();
		this.title = title;
		this.release_date = release_date;
		this.add_date = add_date;
		this.descriptio = descriptio;
		this.tickets = tickets;
		this.statuss = statuss;
		this.photo = photo;
		this.id = id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public Timestamp getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Timestamp add_date) {
		this.add_date = add_date;
	}
	public String getDescriptio() {
		return descriptio;
	}
	public void setDescriptio(String descriptio) {
		this.descriptio = descriptio;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public String getStatuss() {
		return statuss;
	}
	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
