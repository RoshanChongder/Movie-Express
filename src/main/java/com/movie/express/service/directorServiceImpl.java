package com.movie.express.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.express.entity.entityDirector;
import com.movie.express.entity.entityMovie;
import com.movie.express.repository.directorDAO;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class directorServiceImpl implements directorService {

	@Autowired
	private directorDAO dService;
	
	@Override
	public entityDirector saveDirector(entityDirector d) {
		try {
			entityDirector savedD = this.dService.saveAndFlush(d);
			System.out.println("Director save successfully in DB.");
			return savedD;
		} catch(Exception e) {
			System.out.println("Error saving director: " + e);
			return null;
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public entityDirector getDirectorById(int id) {
		try {
			boolean directorExists = this.dService.existsById(id);
			if (directorExists) {
				System.out.println("Director does not exists with id: " + id);
				return null;
			} else {
				return this.dService.findById(id).get();
			}
		} catch (Exception e) {
			System.out.println("Error getting diretor (id - "+ id  + ") : " + e);
			return null;
		}
	}

	@Override
	public void addMovieByDirectorId(int directorId, entityMovie m) {
		try {
			boolean directorExists = this.dService.existsById(directorId);
			if (directorExists) {
				Optional<entityDirector> d = this.dService.findById(directorId);
				System.out.println(d.get());
				d.get().addMovies(m); // Detached entity passed Error. Has a question here.
				System.out.println("Movie added for director with id: " + directorId);
			} else {
				System.out.println("Director with id " + directorId + " not found to add movies");
			}
		} catch (Exception err) {
			System.out.println("Error updating for director with id: " + directorId);
		}
		
	}

}
