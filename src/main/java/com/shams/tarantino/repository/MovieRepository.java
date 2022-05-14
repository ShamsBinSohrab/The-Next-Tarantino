package com.shams.tarantino.repository;

import com.shams.tarantino.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/** Spring Data JPA repository for the {@link Movie} entity. */
public interface MovieRepository extends JpaRepository<Movie, Long> {}
