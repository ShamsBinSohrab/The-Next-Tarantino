package com.shams.tarantino.service;

import com.shams.tarantino.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** Service class for managing movies. */
@Service
@RequiredArgsConstructor
public class MovieService {

  private final MovieRepository movieRepository;
}
