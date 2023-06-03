package com.movie.express.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movie.express.entity.entityDirector;

public interface directorDAO extends JpaRepository<entityDirector, Integer> {}
