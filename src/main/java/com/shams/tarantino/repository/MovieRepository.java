package com.shams.tarantino.repository;

import com.shams.tarantino.domain.Movie;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

/** Spring Data JPA repository for the {@link Movie} entity. */
public interface MovieRepository extends JpaRepository<Movie, Long> {

  Set<Movie> findAllByUserIdAndWatchedEquals(long userId, boolean watched);

  Set<Movie> findAllByUserIdAndWatchedEqualsAndFavouriteEquals(
      long userId, boolean watched, boolean favourite);

  Set<Movie> findAllByUserIdAndWatchedIsTrueAndTitleContaining(long userId, String title);
}
