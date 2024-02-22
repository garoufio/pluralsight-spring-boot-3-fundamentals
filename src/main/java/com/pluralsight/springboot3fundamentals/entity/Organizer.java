package com.pluralsight.springboot3fundamentals.entity;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Organizer {

  @Positive(message = "Organizer id must be a positive number")
  private int id;
  @NotEmpty(message = "Organizer name is required")
  @Size(min = 1, max = 100, message = "Organizer name must be between 1 and 100 characters")
  private String name;
  private String description;

}