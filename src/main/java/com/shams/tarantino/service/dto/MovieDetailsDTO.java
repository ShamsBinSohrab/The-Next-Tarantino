package com.shams.tarantino.service.dto;

import java.util.List;

public class MovieDetailsDTO {

    private String title;

    private String year;

    private String rated;

    private String released;

    private String runtime;

    private String genre;

    private String director;

    private String writer;

    private String actors;

    private String plot;

    private String language;

    private String country;

    private String awards;

    private String poster;

    private List<MovieRatingDTO> ratings;

    private String metaScore;

    private String imdbRating;

    private String imdbVotes;

    private String imdbId;

    private String type;

    private String dvd;

    private String boxOffice;

    private String production;

    private String website;

    private String response;

    public String getTitle() {
        return title;
    }

    public MovieDetailsDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getYear() {
        return year;
    }

    public MovieDetailsDTO setYear(String year) {
        this.year = year;
        return this;
    }

    public String getRated() {
        return rated;
    }

    public MovieDetailsDTO setRated(String rated) {
        this.rated = rated;
        return this;
    }

    public String getReleased() {
        return released;
    }

    public MovieDetailsDTO setReleased(String released) {
        this.released = released;
        return this;
    }

    public String getRuntime() {
        return runtime;
    }

    public MovieDetailsDTO setRuntime(String runtime) {
        this.runtime = runtime;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public MovieDetailsDTO setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public MovieDetailsDTO setDirector(String director) {
        this.director = director;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public MovieDetailsDTO setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public String getActors() {
        return actors;
    }

    public MovieDetailsDTO setActors(String actors) {
        this.actors = actors;
        return this;
    }

    public String getPlot() {
        return plot;
    }

    public MovieDetailsDTO setPlot(String plot) {
        this.plot = plot;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public MovieDetailsDTO setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public MovieDetailsDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAwards() {
        return awards;
    }

    public MovieDetailsDTO setAwards(String awards) {
        this.awards = awards;
        return this;
    }

    public String getPoster() {
        return poster;
    }

    public MovieDetailsDTO setPoster(String poster) {
        this.poster = poster;
        return this;
    }

    public List<MovieRatingDTO> getRatings() {
        return ratings;
    }

    public MovieDetailsDTO setRatings(
        List<MovieRatingDTO> ratings) {
        this.ratings = ratings;
        return this;
    }

    public String getMetaScore() {
        return metaScore;
    }

    public MovieDetailsDTO setMetaScore(String metaScore) {
        this.metaScore = metaScore;
        return this;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public MovieDetailsDTO setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
        return this;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public MovieDetailsDTO setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
        return this;
    }

    public String getImdbId() {
        return imdbId;
    }

    public MovieDetailsDTO setImdbId(String imdbId) {
        this.imdbId = imdbId;
        return this;
    }

    public String getType() {
        return type;
    }

    public MovieDetailsDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getDvd() {
        return dvd;
    }

    public MovieDetailsDTO setDvd(String dvd) {
        this.dvd = dvd;
        return this;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public MovieDetailsDTO setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
        return this;
    }

    public String getProduction() {
        return production;
    }

    public MovieDetailsDTO setProduction(String production) {
        this.production = production;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public MovieDetailsDTO setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public MovieDetailsDTO setResponse(String response) {
        this.response = response;
        return this;
    }

    public static class MovieRatingDTO {

        private String source;

        private String value;

        public String getSource() {
            return source;
        }

        public MovieRatingDTO setSource(String source) {
            this.source = source;
            return this;
        }

        public String getValue() {
            return value;
        }

        public MovieRatingDTO setValue(String value) {
            this.value = value;
            return this;
        }
    }
}
