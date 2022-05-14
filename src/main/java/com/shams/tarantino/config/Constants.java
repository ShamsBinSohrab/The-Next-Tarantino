package com.shams.tarantino.config;

/** Application constants. */
public final class Constants {

  // Regex for acceptable logins
  public static final String LOGIN_REGEX =
      "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";

  public static final String SYSTEM = "system";
  public static final String DEFAULT_LANGUAGE = "en";

  public static final String JSON = "json";
  public static final String MOVIE_API_URL = "https://movie-database-alternative.p.rapidapi.com";
  public static final String RAPID_API_HOST_VALUE = "movie-database-alternative.p.rapidapi.com";

  private Constants() {}
}
