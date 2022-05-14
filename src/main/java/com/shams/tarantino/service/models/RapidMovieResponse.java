package com.shams.tarantino.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shams.tarantino.domain.Movie;
import java.util.List;

public record RapidMovieResponse(@JsonProperty("Search") List<MovieResponse> search) {

    public record MovieResponse(@JsonProperty("Title") String title,
                                @JsonProperty("Year") String year,
                                @JsonProperty("imdbID") String imdbId,
                                @JsonProperty("Type") String type,
                                @JsonProperty("Poster") String poster) {

         public Movie toMovie() {
             var movie = new Movie();
             movie.setTitle(title);
             movie.setYear(year);
             movie.setImdbId(imdbId);
             movie.setType(type);
             movie.setPoster(poster);
             return movie;
         }
        }
}
