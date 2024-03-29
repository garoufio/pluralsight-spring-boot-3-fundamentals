package com.pluralsight.springboot3fundamentals.repository;

import org.springframework.stereotype.Repository;
import com.pluralsight.springboot3fundamentals.entity.Registration;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class RegistrationRepository {

  private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

  private final Map<String, Registration> registrationsByTicketCode = new ConcurrentHashMap<>();

  //--------------------------------------------------------------------------------------------------------------------

  public Registration create(Registration registration) {
    int id = ID_GENERATOR.incrementAndGet();
    String ticketCode = UUID.randomUUID().toString();

    var saved = new Registration(id, registration.getProductId(), ticketCode, registration.getAttendeeName());
    registrationsByTicketCode.put(ticketCode, saved);
    return saved;
  }

  //--------------------------------------------------------------------------------------------------------------------

  public Optional<Registration> findByTicketCode(String ticketCode) {
    return Optional.ofNullable(registrationsByTicketCode.get(ticketCode));
  }

  //--------------------------------------------------------------------------------------------------------------------

  public Registration update(Registration registration) {
    String ticketCode = registration.getTicketCode();

    var opt = findByTicketCode(ticketCode);
    if (opt.isPresent()) {
      var existing = opt.get();

      var saved = new Registration(
        existing.getId(), existing.getProductId(), existing.getTicketCode(), registration.getAttendeeName()
      );
      registrationsByTicketCode.put(ticketCode, saved);
      return saved;
    } else {
      throw new NoSuchElementException(String.format("Registration with ticket code '%s' not found", ticketCode));
    }
  }

  //--------------------------------------------------------------------------------------------------------------------

  public void deleteByTicketCode(String ticketCode) {
    registrationsByTicketCode.remove(ticketCode);
  }

  //--------------------------------------------------------------------------------------------------------------------

}
