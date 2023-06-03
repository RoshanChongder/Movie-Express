package com.movie.express.service;

import java.util.Optional;

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
	public entityMovie saveMovie(entityMovie m) {
		try {
			entityMovie savedMovie = this.mService.saveAndFlush(m);
			System.out.println("Movie " + m.getMovieTitle() + " saved successfully.");
			return savedMovie;
		} catch(Exception e) {
			System.out.println("Error saving movie: " + e);
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<entityMovie> getMovieById(int id) {
		try {
			boolean movieExists = this.mService.existsById(id);
			if (movieExists) {
				// why here getById or getOne() etc will not work, note that down.
				// actual exception will come when we will try to access the returned ref.
				return this.mService.findById(id);
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
