package com.movie.express.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.express.entity.entityDirector;
import com.movie.express.repository.directorDAO;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class directorServiceImpl implements directorService {

	@Autowired
	private directorDAO dService;
	
	@Override
	public void saveDirector(entityDirector d) {
		try {
			this.dService.saveAndFlush(d);
			System.out.println("Director save successfully in DB.");
		} catch(Exception e) {
			System.out.println("Error saving director: " + e);
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
				return this.dService.getById(id);
			}
		} catch (Exception e) {
			System.out.println("Error getting diretor (id - "+ id  + ") : " + e);
			return null;
		}
	}

}
