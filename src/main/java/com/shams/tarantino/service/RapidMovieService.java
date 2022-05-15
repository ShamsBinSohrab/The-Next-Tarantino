package com.shams.tarantino.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shams.tarantino.config.Constants;
import com.shams.tarantino.domain.Movie;
import com.shams.tarantino.service.models.RapidMovieDetailsResponse;
import com.shams.tarantino.service.models.RapidMovieResponse;
import com.shams.tarantino.service.models.RapidMovieResponse.MovieResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.testcontainers.shaded.okhttp3.HttpUrl;
import org.testcontainers.shaded.okhttp3.OkHttpClient;
import org.testcontainers.shaded.okhttp3.Request;

@Service
class RapidMovieService {

    private static final HttpUrl MOVIE_API_URL = HttpUrl.parse(Constants.MOVIE_API_URL);
    private static final String TITLE_SEARCH_QUERY_PARAM = "s";
    private static final String MOVIE_ID_QUERY_PARAM = "i";
    private static final String RESPONSE_TYPE_QUERY_PARAM = "r";
    private static final String RAPID_API_HOST = "X-Rapidapi-Host";
    private static final String RAPID_API_KEY = "X-Rapidapi-Key";

    private final OkHttpClient httpClient;
    private final String rapidApiKey;
    private final ObjectMapper objectMapper;

    public RapidMovieService(
        OkHttpClient httpClient,
        @Value("${rapid-api.key}") String rapidApiKey,
        ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.rapidApiKey = rapidApiKey;
        this.objectMapper = objectMapper;
    }

    public Set<Movie> getMovies(String title) {
        var request = getRequest(searchMovieByTitleUrl(title));
        var call = httpClient.newCall(request);
        try (var response = call.execute()) {
            var body = response.body();
            var rapidMovieResponse = objectMapper.readValue(body.string(),
                RapidMovieResponse.class);
            return rapidMovieResponse.search().stream()
                .map(MovieResponse::toMovie)
                .collect(Collectors.toSet());
        } catch (IOException ex) {
            return Collections.emptySet();
        }
    }

    public Optional<RapidMovieDetailsResponse> getMovieDetails(String imdbId) {
        var request = getRequest(movieDetailsUrl(imdbId));
        var call = httpClient.newCall(request);
        try (var response = call.execute()) {
            var body = response.body();
            var details =
                objectMapper.readValue(body.string(),
                    RapidMovieDetailsResponse.class);
            return Optional.of(details);
        } catch (IOException ex) {
            return Optional.empty();
        }
    }

    private HttpUrl searchMovieByTitleUrl(String title) {
        return MOVIE_API_URL
            .newBuilder()
            .addQueryParameter(TITLE_SEARCH_QUERY_PARAM, title)
            .addQueryParameter(RESPONSE_TYPE_QUERY_PARAM, Constants.JSON)
            .build();
    }

    private HttpUrl movieDetailsUrl(String imdbId) {
        return MOVIE_API_URL
            .newBuilder()
            .addQueryParameter(MOVIE_ID_QUERY_PARAM, imdbId)
            .addQueryParameter(RESPONSE_TYPE_QUERY_PARAM, Constants.JSON)
            .build();
    }

    private Request getRequest(HttpUrl url) {
        return new Request.Builder()
            .url(url)
            .addHeader(RAPID_API_HOST, Constants.RAPID_API_HOST_VALUE)
            .addHeader(RAPID_API_KEY, rapidApiKey)
            .build();
    }
}
