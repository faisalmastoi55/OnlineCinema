package com.cinema.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cinema.dao.MovieService;
import com.cinema.entities.Movie;

public class MovieServiceImpl implements MovieService {
	
	private Connection con;
	
	public MovieServiceImpl(Connection con) {
		super();
		this.con = con;
	}


	@Override
	public Boolean addMovie(Movie movie) {
		Boolean f = false;
		
		try {
			
			String query = "insert into movie(title,release_date,descriptio,tickets,statuss,photo,id) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getRelease_date());
			ps.setString(3, movie.getDescriptio());
			ps.setInt(4, movie.getTickets());
			ps.setString(5, movie.getStatuss());
			ps.setString(6, movie.getPhoto());
			ps.setInt(7, movie.getId());
			
			ps.executeUpdate();
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}


	@Override
	public List<Movie> getAllMovies() {
		List<Movie> list = new ArrayList<Movie>();
		
		Movie movie = null;
		
		try {
			
			String query = "select * from movie where statuss= ? order by movie_id DESC";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "1");
			
			ResultSet rs = ps.executeQuery();
			//int i = 1;
			while(rs.next()) {
				movie = new Movie();
				movie.setMovie_id(rs.getInt(1));
				movie.setTitle(rs.getString(2));
				movie.setRelease_date(rs.getString(3));
				movie.setAdd_date(rs.getTimestamp(4));
				movie.setDescriptio(rs.getString(5));
				movie.setTickets(rs.getInt(6));
				movie.setStatuss(rs.getString(7));
				movie.setPhoto(rs.getString(8));
				movie.setId(rs.getInt(9));
				
				list.add(movie);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public List<Movie> getMovieByAdminId(int id) {
		List<Movie> list = new ArrayList<Movie>();
		Movie movie = null;
		
		try {
			
			String query = "select * from movie where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				movie = new Movie();
				movie.setMovie_id(rs.getInt(1));
				movie.setTitle(rs.getString(2));
				movie.setRelease_date(rs.getString(3));
				movie.setAdd_date(rs.getTimestamp(4));
				movie.setDescriptio(rs.getString(5));
				movie.setTickets(rs.getInt(6));
				movie.setStatuss(rs.getString(7));
				movie.setPhoto(rs.getString(8));
				movie.setId(rs.getInt(9));
				
				list.add(movie);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public Movie getMovieById(int id) {
		Movie movie = null;
		
		try {
			
			String query = "select * from movie where movie_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				movie = new Movie();
				movie.setMovie_id(rs.getInt(1));
				movie.setTitle(rs.getString(2));
				movie.setRelease_date(rs.getString(3));
				movie.setAdd_date(rs.getTimestamp(4));
				movie.setDescriptio(rs.getString(5));
				movie.setTickets(rs.getInt(6));
				movie.setStatuss(rs.getString(7));
				movie.setPhoto(rs.getString(8));
				movie.setId(rs.getInt(9));
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movie;
	}


	@Override
	public Boolean updateMovie(Movie movie) {
		Boolean f = false;
		
		try {
			
			String query = "update movie set title = ?, release_date = ?, descriptio = ?, tickets = ?, statuss = ? where movie_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getRelease_date());
			ps.setString(3, movie.getDescriptio());
			ps.setInt(4, movie.getTickets());
			ps.setString(5, movie.getStatuss());
			ps.setInt(6, movie.getMovie_id());
			
			ps.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}


	@Override
	public String getPhotoByMovieId(int id) {
		String photoFileName = null;
		
		try {
			
			String query = "select photo from movie where movie_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				photoFileName = rs.getString("photo");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return photoFileName;
	}


	@Override
	public Boolean deleteMovie(int id) {
		Boolean f = false;
		
		try {
			
			String query = "delete from movie where movie_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			f = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

}
