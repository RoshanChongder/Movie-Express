package com.movie.express.service;

import com.movie.express.entity.entityMovie;

public interface commonService {
	public void addMovieToDirector(int directorId, entityMovie m);
	public void saveMovie(entityMovie m);
}
