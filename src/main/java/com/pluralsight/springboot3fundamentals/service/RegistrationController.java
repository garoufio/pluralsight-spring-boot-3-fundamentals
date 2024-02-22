package com.pluralsight.springboot3fundamentals.service;

import com.pluralsight.springboot3fundamentals.entity.Registration;
import com.pluralsight.springboot3fundamentals.repository.RegistrationRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/tickets/registrations")
public class RegistrationController {

  private final RegistrationRepository registrationRepository;

  //--------------------------------------------------------------------------------------------------------------------

  public RegistrationController(RegistrationRepository registrationRepository) {
    this.registrationRepository = registrationRepository;
  }

  //--------------------------------------------------------------------------------------------------------------------

  @PostMapping
  public Registration create(@RequestBody @Valid Registration registration) {
    return registrationRepository.create(registration);
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path = "/{ticketCode}")
  public Registration get(@PathVariable("ticketCode") String ticketCode) {
    return registrationRepository.
      findByTicketCode(ticketCode).
      orElseThrow(
        () -> new NoSuchElementException(String.format("Registration with ticket code '%s' not found", ticketCode))
      );
  }

  //--------------------------------------------------------------------------------------------------------------------

  @PutMapping
  public Registration update(@RequestBody Registration registration) {
    return registrationRepository.update(registration);
  }

  //--------------------------------------------------------------------------------------------------------------------

  @DeleteMapping(path = "/{ticketCode}")
  public void delete(@PathVariable("ticketCode") String ticketCode) {
    registrationRepository.deleteByTicketCode(ticketCode);
  }

  //--------------------------------------------------------------------------------------------------------------------

}
