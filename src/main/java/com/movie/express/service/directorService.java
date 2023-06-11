package com.movie.express.service;

import com.movie.express.entity.entityDirector;
import com.movie.express.entity.entityMovie;

public interface directorService {
	public entityDirector saveDirector(entityDirector D);
	public entityDirector getDirectorById(int id);
	public void deleteDirectorById(int directorId);
	public void deleteAllRecord();
}
