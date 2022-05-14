package com.shams.tarantino.web.rest;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.shams.tarantino.service.MovieService;
import com.shams.tarantino.service.dto.MovieDTO;
import com.shams.tarantino.web.rest.util.UserId;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
      @RequestParam(required = false) boolean watched,
      @RequestParam(required = false) boolean favourite,
      @RequestParam(required = false) String title,
      @UserId Long userId) {
    var movies =
        isBlank(title)
            ? movieService.getAllMoviesForUser(userId, watched, favourite)
            : movieService.getAllMoviesForUserByTitle(userId, title);
    return movies.stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList();
  }
}
