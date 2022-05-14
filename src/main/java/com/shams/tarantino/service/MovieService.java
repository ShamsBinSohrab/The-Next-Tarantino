package com.shams.tarantino.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shams.tarantino.config.Constants;
import com.shams.tarantino.domain.Movie;
import com.shams.tarantino.repository.MovieRepository;
import com.shams.tarantino.service.models.RapidMovieResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.shaded.okhttp3.HttpUrl;
import org.testcontainers.shaded.okhttp3.OkHttpClient;
import org.testcontainers.shaded.okhttp3.Request;

/** Service class for managing movies. */
@Service
@Transactional(readOnly = true)
public class MovieService {

  private static final HttpUrl MOVIE_API_URL = HttpUrl.parse(Constants.MOVIE_API_URL);
  private static final String TITLE_SEARCH_QUERY_PARAM = "s";
  private static final String RESPONSE_TYPE_QUERY_PARAM = "r";
  private static final String RAPID_API_HOST = "X-Rapidapi-Host";
  private static final String RAPID_API_KEY = "X-Rapidapi-Key";

  private final MovieRepository movieRepository;
  private final OkHttpClient httpClient;
  private final String rapidApiKey;
  private final ObjectMapper objectMapper;

  public MovieService(
      MovieRepository movieRepository,
      OkHttpClient httpClient,
      @Value("${rapid-api.key}") String rapidApiKey,
      ObjectMapper objectMapper) {
    this.movieRepository = movieRepository;
    this.httpClient = httpClient;
    this.rapidApiKey = rapidApiKey;
    this.objectMapper = objectMapper;
  }

  public List<Movie> getAllMoviesForUser(long userId, boolean watched, boolean favourite) {
    return movieRepository.findAllByUserIdAndWatchedEqualsAndFavouriteEquals(
        userId, watched, favourite);
  }

  public List<Movie> getAllWatchedMoviesForUserByTitle(long userId, String title) {
    return movieRepository.findAllByUserIdAndWatchedIsTrueAndTitleContainingIgnoreCase(
        userId, title);
  }

  public List<Movie> getMoviesOnline(String title) {
    var httpUrl =
        MOVIE_API_URL
            .newBuilder()
            .addQueryParameter(TITLE_SEARCH_QUERY_PARAM, title)
            .addQueryParameter(RESPONSE_TYPE_QUERY_PARAM, Constants.JSON)
            .build();
    var request =
        new Request.Builder()
            .url(httpUrl)
            .addHeader(RAPID_API_HOST, Constants.RAPID_API_HOST_VALUE)
            .addHeader(RAPID_API_KEY, rapidApiKey)
            .build();
    var call = httpClient.newCall(request);
    try (var response = call.execute()) {
      var body = response.body();
      var resp = objectMapper.readValue(body.string(), RapidMovieResponse.class);
      return List.of();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
}
