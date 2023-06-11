package com.movie.express.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.express.entity.entityDirector;
import com.movie.express.entity.entityMovie;

@Service
public class commonServiceImpl implements commonService {

	@Autowired
	private movieService ms;
	
	@Autowired
	private directorService ds;
	
	@Override
	@Transactional
	public void addMovieToDirector(int directorId, entityMovie m) {
		entityDirector d = this.ds.getDirectorById(directorId);
		System.out.println("Found directorL " + d);
		if (d != null) {
			/*Update Director*/
			d.addMovies(m);
			m.setDirector(d);
		}

	}

	@Override
	public void saveMovie(entityMovie m) {
		this.ms.saveMovie(m);

	}

}
