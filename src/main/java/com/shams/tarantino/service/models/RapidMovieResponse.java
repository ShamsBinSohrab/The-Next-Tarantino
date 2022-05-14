package com.shams.tarantino.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record RapidMovieResponse(@JsonProperty("Search") List<MovieResponse> search) {

    public record MovieResponse(@JsonProperty("Title") String title,
                                @JsonProperty("Year") short year,
                                @JsonProperty("imdbID") String imdbId,
                                @JsonProperty("Type") String type,
                                @JsonProperty("Poster") String poster) {
        }
}
