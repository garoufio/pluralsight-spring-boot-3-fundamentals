package com.pluralsight.springboot3fundamentals.repository;

import org.springframework.stereotype.Repository;
import com.pluralsight.springboot3fundamentals.entity.Event;
import com.pluralsight.springboot3fundamentals.entity.Organizer;
import com.pluralsight.springboot3fundamentals.entity.Venue;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

  private final List<Event> events = List.of(
    new Event(
      501, "Globomantics Tech Conference",
      new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
      new Venue(201, "Globomatics Main Office", "Test Street 325", "New York", "10007", "USA"),
      LocalDate.of(2023, 10, 2),
      LocalDate.of(2023, 10, 4)
    ),
    new Event(
      502, "Globomantics Developer Day",
      new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
      new Venue(201, "Globomatics Main Office", "Test Street 325", "New York", "10009", "USA"),
      LocalDate.of(2024, 1, 10),
      LocalDate.of(2024, 1, 10)
    ),
    new Event(
      503, "Carved Rock New Products Day",
      new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment"),
      new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "90011","USA"),
      LocalDate.of(2024, 2, 29),
      LocalDate.of(2024, 2, 29)
    )
  );

  //--------------------------------------------------------------------------------------------------------------------

  public List<Event> findByOrganizerId(int organizerId) {
    return events.stream().
      filter(event -> event.getOrganizer().getId() == organizerId).
      toList();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public List<Event> findByVenueId(int venueId) {
    return events.stream().
      filter(event -> event.getVenue().getId() == venueId).
      toList();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public List<Event> findByOrganizerIdAndVenueId(int organizerId, int venueId) {
    return events.stream().
      filter(event -> event.getOrganizer().getId() == organizerId && event.getVenue().getId() == venueId).
      toList();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public Optional<Event> findById(int id) {
    return events.stream().
      filter(event -> event.getId() == id).
      findAny();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public List<Event> findAll(){
    return events;
  }

  //--------------------------------------------------------------------------------------------------------------------

}
