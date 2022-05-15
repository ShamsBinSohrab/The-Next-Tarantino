package com.shams.tarantino.service.dto;

public class MovieReviewDTO {

  private long id;

  private String review;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }
}
