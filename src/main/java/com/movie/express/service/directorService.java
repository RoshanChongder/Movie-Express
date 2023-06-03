package com.movie.express.service;

import com.movie.express.entity.entityDirector;

public interface directorService {
	public void saveDirector(entityDirector D);
	public entityDirector getDirectorById(int id);
}
