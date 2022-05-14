package com.shams.tarantino.web.rest;

import com.shams.tarantino.security.AuthoritiesConstants;
import com.shams.tarantino.service.MovieService;
import com.shams.tarantino.service.dto.MovieDTO;
import com.shams.tarantino.web.rest.util.UserId;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
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
  @PreAuthorize("hasAuthority(\"" + AuthoritiesConstants.USER + "\")")
  List<MovieDTO> movies(
      @RequestParam(required = false) boolean watched,
      @RequestParam(required = false) boolean favourite,
      @UserId Long userId) {
    var movies = movieService.getAll(watched, favourite);
    return movies.stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList();
  }
}
