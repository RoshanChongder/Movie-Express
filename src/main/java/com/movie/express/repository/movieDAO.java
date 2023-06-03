package com.movie.express.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movie.express.entity.entityMovie;

public interface movieDAO extends JpaRepository<entityMovie, Integer> {}
