package com.shams.tarantino.service;

import com.shams.tarantino.domain.MovieReview;
import com.shams.tarantino.repository.MovieReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MovieReviewService {

  private final MovieReviewRepository movieReviewRepository;

  public MovieReviewService(MovieReviewRepository movieReviewRepository) {
    this.movieReviewRepository = movieReviewRepository;
  }

  public MovieReview getByMovieId(long movieId) {
    return movieReviewRepository.findByMovieId(movieId).orElseThrow();
  }
}
