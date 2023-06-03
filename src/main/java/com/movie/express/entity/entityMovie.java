package com.movie.express.entity;

import java.time.Duration;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// import jakarta.persistence.Temporal;
// import jakarta.persistence.TemporalType;
// import java.time.LocalDateTime;

@Entity
@Table(name="MOVIE_TABLE")
public class entityMovie {
	
	@Id
	@Column(name="MOVIE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO )
	int movieId;
	
	@Column(name="MOVIE_TITLE")
	String movieTitle;
	
    // @Temporal(value = TemporalType.DATE)
	// It is to be added for java.util.Date and java.Util.DateTime.
	@Column(name="RELEASE_DATE")
	LocalDate dateReleased;
	
	// @Temporal(value = TemporalType.TIME)
	// It is to be added for java.util.Date and java.Util.DateTime.
	@Column(name = "DURATION")
	Duration duration;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DIRECTOR_ID")
	entityDirector director;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public LocalDate getDateReleased() {
		return dateReleased;
	}

	public void setDateReleased(LocalDate dateReleased) {
		this.dateReleased = dateReleased;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public entityDirector getDirector() {
		return director;
	}

	public void setDirector(entityDirector director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie: [movieId=" + movieId + ", movieTitle=" + movieTitle + ", dateReleased=" + dateReleased
				+ ", duration=" + duration + ", director=" + director + "]\n";
	}
	
}
