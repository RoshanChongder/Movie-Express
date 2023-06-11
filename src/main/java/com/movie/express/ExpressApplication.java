package com.movie.express;

import java.time.Duration;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.movie.express.entity.entityDirector;
import com.movie.express.entity.entityMovie;
import com.movie.express.service.commonService;
import com.movie.express.service.commonServiceImpl;
import com.movie.express.service.directorService;
import com.movie.express.service.directorServiceImpl;
import com.movie.express.service.movieService;
import com.movie.express.service.movieServiceImpl;

@SpringBootApplication
public class ExpressApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(ExpressApplication.class, args);
		
		// Setting up service beans
		movieService movieService = ctx.getBean(movieServiceImpl.class);
		directorService directorService = ctx.getBean(directorServiceImpl.class);
		commonService cService = ctx.getBean(commonServiceImpl.class);
		
		movieService.deleteAllRecord();
		directorService.deleteAllRecord();
		
		// Add Movie Example
		entityMovie m1 = new entityMovie();
		m1.setMovieTitle("Koi Mil Gaya");
		LocalDate releaseDate = LocalDate.of(2003, 8, 8);
		Duration d = Duration.ofHours((long) 3.1);
		m1.setDateReleased(releaseDate);
		m1.setDuration(d);
		
		// Director1
		entityDirector dir1 = new entityDirector();
		dir1.setFirstName("Rakesh");
		dir1.setLastName("Roshan");
		dir1.setAddress("Mumbai, India");
		dir1.setContactNumber(100100100);
		dir1.setEmial("rakesh.roshan@yahoo.com");
		
		m1.setDirector(dir1);
		dir1.addMovies(m1);
		
		// movieService.saveMovie(m1);
		directorService.saveDirector(dir1);
		
		// Creating two more movies
		entityMovie m2 = new entityMovie();
		m2.setMovieTitle("Krish1");
		LocalDate releaseDate1 = LocalDate.of(2005, 1, 12);
		Duration d1 = Duration.ofHours((long) 3.1);
		m2.setDateReleased(releaseDate1);
		m2.setDuration(d1);
		
		// m2 = movieService.saveMovie(m2);
		cService.addMovieToDirector(dir1.getDirectorId(), m2);
		
		/*entityMovie m3 = new entityMovie();
		m3.setMovieTitle("Krish2");
		LocalDate releaseDate2 = LocalDate.of(2007, 3, 5);
		Duration d2 = Duration.ofHours((long) 3.1);
		m1.setDateReleased(releaseDate2);
		m1.setDuration(d2);*/
		
	}

}
