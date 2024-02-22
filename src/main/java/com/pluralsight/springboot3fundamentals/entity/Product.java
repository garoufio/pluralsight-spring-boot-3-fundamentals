package com.pluralsight.springboot3fundamentals.entity;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;
import lombok.Data;
import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Product {

  @Positive(message = "Product id must be a positive number")
  private int id;
  private int eventId;
  @NotEmpty(message = "Product name is required")
  @Size(min = 1, max = 100, message = "Product name must be between 1 and 100 characters")
  private String name;
  private String description;
  @Positive(message = "Product price must be greater than 0")
  private BigDecimal price;

}