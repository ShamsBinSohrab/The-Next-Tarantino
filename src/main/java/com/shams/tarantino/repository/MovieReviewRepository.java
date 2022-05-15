package com.shams.tarantino.repository;

import com.shams.tarantino.domain.MovieReview;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** Spring Data JPA repository for the {@link MovieReview} entity. */
public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {

  Optional<MovieReview> findByMovieId(long movieId);
}
