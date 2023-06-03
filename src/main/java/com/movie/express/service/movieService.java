package com.movie.express.service;

import java.util.Optional;

import com.movie.express.entity.entityMovie;

public interface movieService {
	public entityMovie saveMovie(entityMovie m);
	public Optional<entityMovie> getMovieById(int id);
}
