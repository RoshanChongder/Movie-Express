package com.movie.express.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIRECTOR")
public class entityDirector {

	@Id
	@Column(name = "DIRECTOR_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int directorId;
	
	@Column(name = "FIRST_NAME")
	String firstName;
	
	@Column(name = "LAST_NAME")
	String lastName;
	
	@Column(name = "ADDRESS")
	String address;
	
	@Column(name = "CONTACT_NUMBER")
	long contactNumber;
	
	@Column(name = "EMIAL_ID")
	String emial;
	
	@OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
	List<entityMovie> movies;
	
	public entityDirector() {
		this.movies = new ArrayList<entityMovie>();
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}
	
	

	public List<entityMovie> getMovies() {
		return movies;
	}

	public void setMovies(List<entityMovie> movies) {
		this.movies = movies;
	}
	
	public void addMovies(List<entityMovie> movies) {
		if (movies.size() > 0) {
			for(entityMovie m: movies) {
				this.movies.add(m);
			}
		}
	}
	
	public void addMovies(entityMovie movie) {
		if (movie!= null) {
		 this.movies.add(movie);
		}
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", contactNumber=" + contactNumber + ", emial=" + emial + "]\n";
	}
	
	
	
}
