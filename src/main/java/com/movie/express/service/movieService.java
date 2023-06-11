package com.movie.express.service;

import java.util.Optional;

import com.movie.express.entity.entityMovie;

public interface movieService {
	public entityMovie saveMovie(entityMovie m);
	public entityMovie getMovieById(int id);
	public void deleteAllRecord();
	public void deleteMovieById(int movieID);
}
