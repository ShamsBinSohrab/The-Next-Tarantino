package com.shams.tarantino.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shams.tarantino.service.dto.MovieDetailsDTO;
import com.shams.tarantino.service.dto.MovieDetailsDTO.MovieRatingDTO;
import java.util.List;

public record RapidMovieDetailsResponse(@JsonProperty("Title") String title,
                                        @JsonProperty("Year") String year,
                                        @JsonProperty("Rated") String rated,
                                        @JsonProperty("Released") String released,
                                        @JsonProperty("Runtime") String runtime,
                                        @JsonProperty("Genre") String genre,
                                        @JsonProperty("Director") String director,
                                        @JsonProperty("Writer") String writer,
                                        @JsonProperty("Actors") String actors,
                                        @JsonProperty("Plot") String plot,
                                        @JsonProperty("Language") String language,
                                        @JsonProperty("Country") String country,
                                        @JsonProperty("Awards") String awards,
                                        @JsonProperty("Poster") String poster,
                                        @JsonProperty("Ratings") List<MovieRating> ratings,
                                        @JsonProperty("Metascore") String metaScore,
                                        @JsonProperty("imdbRating") String imdbRating,
                                        @JsonProperty("imdbVotes") String imdbVotes,
                                        @JsonProperty("imdbID") String imdbId,
                                        @JsonProperty("Type") String type,
                                        @JsonProperty("DVD") String dvd,
                                        @JsonProperty("BoxOffice") String boxOffice,
                                        @JsonProperty("Production") String production,
                                        @JsonProperty("Website") String website,
                                        @JsonProperty("Response") String response) {

    public MovieDetailsDTO toMovieDetailsDTO() {
        return new MovieDetailsDTO()
            .setTitle(title)
            .setYear(year)
            .setRated(rated)
            .setReleased(released)
            .setRuntime(runtime)
            .setGenre(genre)
            .setDirector(director)
            .setWriter(writer)
            .setActors(actors)
            .setPlot(plot)
            .setLanguage(language)
            .setCountry(country)
            .setAwards(awards)
            .setPoster(poster)
            .setRatings(ratings.stream().map(MovieRating::toMovieRatingDTO).toList())
            .setMetaScore(metaScore)
            .setImdbRating(imdbRating)
            .setImdbVotes(imdbVotes)
            .setImdbId(imdbId)
            .setType(type)
            .setDvd(dvd)
            .setBoxOffice(boxOffice)
            .setProduction(production)
            .setWebsite(website)
            .setResponse(response);
    }

    public record MovieRating(@JsonProperty("Source") String source,
                              @JsonProperty("Value") String value) {

        MovieRatingDTO toMovieRatingDTO() {
            return new MovieRatingDTO().setSource(source).setValue(value);
        }

    }

}
