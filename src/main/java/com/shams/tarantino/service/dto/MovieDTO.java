package com.shams.tarantino.service.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/** A DTO representing a movie, with only the public attributes. */
@Getter
@Setter
public class MovieDTO {

  private Long id;

  @NotNull
  @Size(max = 255)
  private String title;

  @Min(1800)
  @Max(3000)
  private short year;

  @NotNull
  @Size(max = 50)
  private String type;

  @NotNull
  @Size(max = 255)
  private String poster;

  private boolean watched;
  private boolean favourite;
}
