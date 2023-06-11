package com.movie.express.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.express.entity.entityDirector;
import com.movie.express.entity.entityMovie;
import com.movie.express.repository.directorDAO;

@Service
public class directorServiceImpl implements directorService {

	@Autowired
	private directorDAO dService;
	
	@Override
	@Transactional()
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

	@Override
	public entityDirector getDirectorById(int id) {
		try {
			Optional<entityDirector> director = this.dService.findById(id);
			if (director.isEmpty()) {
				System.out.println("Director does not exists with id: " + id);
				return null;
			} else {
				return director.get();
			}
		} catch (Exception e) {
			System.out.println("Error getting diretor (id - "+ id  + ") : " + e);
			return null;
		}
	}

	@Override
	public void deleteAllRecord() {
		try {
			this.dService.deleteAll();
		} catch(Exception E) {
			System.out.println("Error deleting all records for director: " + E);
		}
		
	}

	@Override
	public void deleteDirectorById(int directorId) {
		try {
			this.dService.deleteById(directorId);
			System.out.println("Director Delete Successfully with id: " + directorId);
		} catch(Exception e) {
			System.out.println("Error while deleting director with id: " + directorId);
		}
	}

}
