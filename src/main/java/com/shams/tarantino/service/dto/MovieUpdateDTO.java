package com.shams.tarantino.service.dto;

public class MovieUpdateDTO {

  private boolean watched;
  private boolean favourite;

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
