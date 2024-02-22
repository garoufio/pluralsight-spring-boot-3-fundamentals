package com.pluralsight.springboot3fundamentals.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;
import lombok.Data;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Registration {

  @NotNull(message = "Registration ID is required")
  @NonNull
  Integer id;
  @NotNull(message = "Registration productId is required")
  @NonNull
  Integer productId;
  String ticketCode;
  @NotBlank
  @NonNull
  String attendeeName;


}
