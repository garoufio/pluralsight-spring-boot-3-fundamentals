package com.pluralsight.springboot3fundamentals.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Venue {

  @Positive(message = "Venue id must be a positive number")
  private int id;
  @NotEmpty(message = "Venue name is required")
  @Size(min = 1, max = 100, message = "Venue name must be between 1 and 100 characters")
  private String name;
  @NotEmpty(message = "Venue street address is required")
  @Size(min = 1, max = 250, message = "Venue street address must be between 1 and 250 characters")
  private String street;
  @NotEmpty(message = "Venue city is required")
  @Size(min = 1, max = 50, message = "Venue city must be between 1 and 50 characters")
  private String city;
  @NotEmpty(message = "Venue zip code is required")
  @Size(min = 1, max = 10, message = "Venue zip code must be between 1 and 10 characters")
  private String zipCode;
  @NotEmpty(message = "Venue country is required")
  @Size(min = 1, max = 50, message = "Venue country must be between 1 and 50 characters")
  private String country;

}