package com.cinema.dao;

import java.util.List;

import com.cinema.entities.Movie;

public interface MovieService {

	Boolean addMovie(Movie movie);
	
	List<Movie> getAllMovies();
	
	List<Movie> getMovieByAdminId(int id);

	Movie getMovieById(int id);

	Boolean updateMovie(Movie movie);
	
	String getPhotoByMovieId(int id);
	
	Boolean deleteMovie(int id);
	
}
