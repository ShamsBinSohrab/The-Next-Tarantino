package com.shams.tarantino.domain;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_reviews")
public class MovieReview implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review", nullable = false, length = 1024)
    private String review;

    public Long getId() {
        return id;
    }

    public MovieReview setId(Long id) {
        this.id = id;
        return this;
    }

    public String getReview() {
        return review;
    }

    public MovieReview setReview(String review) {
        this.review = review;
        return this;
    }
}
