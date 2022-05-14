package com.shams.tarantino.domain;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 255)
  @Column(name = "title", nullable = false)
  private String title;

  @Min(1800)
  @Max(3000)
  @Column(name = "year", nullable = false)
  private short year;

  @Size(max = 50)
  @Column(name = "imdb_id", length = 50)
  private String imdbId;

  @Size(max = 50)
  @Column(name = "type", length = 50)
  private String type;

  @Size(max = 255)
  @Column(name = "poster")
  private String poster;

  @Column(name = "watched", nullable = false)
  private boolean watched;

  @Column(name = "favourite", nullable = false)
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

  public short getYear() {
    return year;
  }

  public void setYear(short year) {
    this.year = year;
  }

  public String getImdbId() {
    return imdbId;
  }

  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
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
