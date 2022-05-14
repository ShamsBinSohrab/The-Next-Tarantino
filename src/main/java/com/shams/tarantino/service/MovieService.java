package com.shams.tarantino.service;

import com.shams.tarantino.repository.MovieRepository;
import org.springframework.stereotype.Service;

/** Service class for managing movies. */
@Service
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }
}
