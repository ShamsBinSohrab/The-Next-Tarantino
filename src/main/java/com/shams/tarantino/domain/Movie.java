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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie extends AbstractAuditingEntity implements Serializable {

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
}
