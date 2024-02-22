package com.pluralsight.springboot3fundamentals.repository;

import com.pluralsight.springboot3fundamentals.entity.Venue;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {

  private final List<Venue> venues = List.of(
    new Venue(
      201, "Globomatics Main Office", "Test Street 325", "New York", "10007", "USA"
    ),
    new Venue(
      202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "90011", "USA"
    )
  );

  //--------------------------------------------------------------------------------------------------------------------

  public Optional<Venue> findById(int id) {
    return venues.stream().
      filter(venue -> venue.getId() == id).
      findAny();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public List<Venue> findAll() {
    return venues;
  }

  //--------------------------------------------------------------------------------------------------------------------

}