package com.movie.express;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.movie.express.entity.entityDirector;
import com.movie.express.entity.entityMovie;
import com.movie.express.service.directorService;
import com.movie.express.service.directorServiceImpl;
import com.movie.express.service.movieService;
import com.movie.express.service.movieServiceImpl;

@SpringBootApplication
public class ExpressApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ExpressApplication.class, args);
		
		// Setting up service beans
		movieService movieService = ctx.getBean(movieServiceImpl.class);
		directorService directorService = ctx.getBean(directorServiceImpl.class);
		
		// Movie1
		entityMovie m1 = new entityMovie();
		m1.setMovieTitle("Koi Mil Gaya");
		LocalDate releaseDate = LocalDate.of(2003, 8, 8);
		Duration d = Duration.ofHours((long) 3.1);
		m1.setDateReleased(releaseDate);
		m1.setDuration(d);
		movieService.saveMovie(m1);
		
		
		// Director1
		entityDirector dir = new entityDirector();
		dir.setFirstName("Rakesh");
		dir.setLastName("Roshan");
		dir.setAddress("Mumbai, India");
		dir.setContactNumber(100100100);
		dir.setEmial("rakesh.roshan@yahoo.com");
		dir = directorService.saveDirector(dir);
		System.out.println(dir.getDirectorId());
		
		// Update the director for the movie m1
		directorService.addMovieByDirectorId(dir.getDirectorId(), m1);
		
	}

}
