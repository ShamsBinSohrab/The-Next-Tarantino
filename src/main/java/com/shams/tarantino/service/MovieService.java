package com.shams.tarantino.service;

import com.shams.tarantino.domain.Movie;
import com.shams.tarantino.repository.MovieRepository;
import com.shams.tarantino.service.dto.MovieDetailsDTO;
import com.shams.tarantino.service.models.RapidMovieDetailsResponse;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.EntityNotFoundException;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** Service class for managing movies. */
@Service
@Transactional(readOnly = true)
public class MovieService {

    private final MovieRepository movieRepository;
    private final RapidMovieService rapidMovieService;

    public MovieService(
        MovieRepository movieRepository, RapidMovieService rapidMovieService) {
        this.movieRepository = movieRepository;
        this.rapidMovieService = rapidMovieService;
    }

    public Set<Movie> getAllMoviesForUser(long userId, boolean watched, boolean favourite) {
        return movieRepository.findAllByUserIdAndWatchedEqualsAndFavouriteEquals(
            userId, watched, favourite);
    }

    public Set<Movie> searchMoviesForUser(long userId, String title) {
        var result =
            Stream.of(
                    CompletableFuture.supplyAsync(() -> getAllMoviesForUserByTitle(userId, title)),
                    CompletableFuture.supplyAsync(() -> rapidMovieService.getMovies(title)))
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        Movie::getTitle,
                        (movieFromDb, movieFromApi) -> movieFromDb));
        return result.keySet();
    }

    private Set<Movie> getAllMoviesForUserByTitle(long userId, String title) {
        return movieRepository.findAllByUserIdAndWatchedIsTrueAndTitleContaining(userId, title);
    }

    @Transactional
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getById(long id) {
        var movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Hibernate.initialize(movie.getMovieReview());
        return movie;
    }

    @Transactional(propagation = Propagation.NEVER)
    public MovieDetailsDTO getDetails(String imdbId) {
        return rapidMovieService.getMovieDetails(imdbId)
            .map(RapidMovieDetailsResponse::toMovieDetailsDTO)
            .orElseThrow(() -> new IllegalStateException("Unable to get details for: " + imdbId));
    }
}
