package com.movie.express.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.express.entity.entityMovie;
import com.movie.express.repository.movieDAO;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class movieServiceImpl implements movieService {

	@Autowired
	private movieDAO mService;
	
	@Override
	public void saveMovie(entityMovie m) {
		try {
			this.mService.saveAndFlush(m);
			System.out.println("Movie " + m.getMovieTitle() + " saved successfully.");
		} catch(Exception e) {
			System.out.println("Error saving movie: " + e);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public entityMovie getMovieById(int id) {
		try {
			boolean movieExists = this.mService.existsById(id);
			if (movieExists) {
				return this.mService.getById(id);
			} else {
				System.out.println("Movie with id " + id + " does not exists");
				return null;
			}
		} catch(Exception e) {
			System.out.println("Error getting movie details: " + e);
			return null;
		}
	}

}
