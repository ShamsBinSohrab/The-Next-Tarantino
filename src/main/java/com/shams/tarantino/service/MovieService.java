package com.shams.tarantino.service;

import com.shams.tarantino.domain.Movie;
import com.shams.tarantino.repository.MovieRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service class for managing movies. */
@Service
@Transactional(readOnly = true)
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> getAllMoviesForUser(long userId, boolean watched, boolean favourite) {
    return movieRepository.findAllByUserIdAndWatchedEqualsAndFavouriteEquals(
        userId, watched, favourite);
  }

  public List<Movie> getAllWatchedMoviesForUserByTitle(long userId, String title) {
    return movieRepository.findAllByUserIdAndWatchedIsTrueAndTitleLike(userId, title);
  }
}
