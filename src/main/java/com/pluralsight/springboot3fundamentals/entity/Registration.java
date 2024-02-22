package com.pluralsight.springboot3fundamentals.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Registration {

  Integer id;
  @NotNull(message = "Registration productId is required")
  Integer productId;
  String ticketCode;
  @NotBlank (message = "Attendee name is required")
  String attendeeName;

}
