package com.shams.tarantino.web.rest;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.shams.tarantino.domain.Movie;
import com.shams.tarantino.service.MovieService;
import com.shams.tarantino.service.dto.MovieDTO;
import com.shams.tarantino.service.dto.MovieDetailsDTO;
import com.shams.tarantino.service.dto.MovieUpdateDTO;
import com.shams.tarantino.web.rest.util.UserId;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** REST controller for managing movies. */
@RestController
@RequestMapping("/api/movies")
public class MovieResource {

    private final ModelMapper modelMapper;
    private final MovieService movieService;

    public MovieResource(ModelMapper modelMapper, MovieService movieService) {
        this.modelMapper = modelMapper;
        this.movieService = movieService;
    }

  @GetMapping
  List<MovieDTO> movies(
      @RequestParam(required = false) Boolean watched,
      @RequestParam(required = false) Boolean favourite,
      @RequestParam(required = false) String title,
      @UserId Long userId) {
        var movies =
            isBlank(title)
                ? movieService.getAllMoviesForUser(userId, watched, favourite)
                : movieService.searchMoviesForUser(userId, title);
        return movies.stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    MovieDTO store(@RequestBody @Valid MovieDTO movieDTO, @UserId Long userId) {
        var movie = modelMapper.map(movieDTO, Movie.class);
        movie.setUserId(userId);
        movieService.save(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }

    @PatchMapping("/{id}")
    MovieDTO update(@PathVariable long id, @RequestBody @Valid MovieUpdateDTO movieUpdateDTO) {
        var movie = movieService.getById(id);
        movie.setWatched(movieUpdateDTO.isWatched());
        movie.setFavourite(movieUpdateDTO.isFavourite());
        movieService.save(movie);
        return modelMapper.map(movie, MovieDTO.class);
    }

    @GetMapping("/{imdbId}")
    MovieDetailsDTO details(@PathVariable String imdbId) {
        return movieService.getDetails(imdbId);
    }
}
