package com.movie.express.service;

import com.movie.express.entity.entityMovie;

public interface movieService {
	public void saveMovie(entityMovie m);
	public entityMovie getMovieById(int id);
}
