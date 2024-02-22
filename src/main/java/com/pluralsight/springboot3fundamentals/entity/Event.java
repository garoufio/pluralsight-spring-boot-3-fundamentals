package com.pluralsight.springboot3fundamentals.entity;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Event {

  @Positive(message = "Event id must be a positive number")
  private int id;
  @NotEmpty(message = "Event name is required")
  @Size(min = 1, max = 100, message = "Event name must be between 1 and 100 characters")
  private String name;
  @NotNull(message = "Event organizer is required")
  private Organizer organizer;
  @NotNull(message = "Event venue is required")
  private Venue venue;
  @NotNull(message = "Event start date is required")
  @FutureOrPresent(message = "Event start date must be greater than or equal to present date")
  private LocalDate startDate;
  @NotNull(message = "Event end date is required")
  @FutureOrPresent(message = "Event end date must be greater than or equal to present date")
  private LocalDate endDate;

}
