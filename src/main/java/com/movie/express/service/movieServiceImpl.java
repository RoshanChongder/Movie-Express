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


	@Override
	public entityMovie getMovieById(int id) {
		try {
			Optional<entityMovie> movie = this.mService.findById(id);
			if (movie.isPresent()) {
				return movie.get();
			} else {
				System.out.println("Movie with id " + id + " does not exists");
				return null;
			}
		} catch(Exception e) {
			System.out.println("Error getting movie details: " + e);
			return null;
		}
	}

	@Override
	public void deleteAllRecord() {
		try {
			this.mService.deleteAll();
		} catch(Exception e) {
			System.out.println("Error deleting all records for Movies: " + e);
		}
		
	}


	@Override
	public void deleteMovieById(int movieId) {
		try {
			this.mService.deleteById(movieId);
			System.out.println("Movie Deleted Succesfully With Id: " + movieId);
		} catch(Exception e) {
			System.out.println("Error while deleting movie with id: " + movieId);
		}
		
	}

}
