package com.shams.tarantino.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** A DTO representing a movie, with only the public attributes. */
public class MovieDTO {

  private Long id;

  @NotNull
  @Size(max = 255)
  private String title;

  @Size(max = 4)
  private String year;

  @Size(max = 50)
  private String type;

  @Size(max = 255)
  private String poster;

  private boolean watched;
  private boolean favourite;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }

  public boolean isWatched() {
    return watched;
  }

  public void setWatched(boolean watched) {
    this.watched = watched;
  }

  public boolean isFavourite() {
    return favourite;
  }

  public void setFavourite(boolean favourite) {
    this.favourite = favourite;
  }
}
