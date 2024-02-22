package com.pluralsight.springboot3fundamentals.repository;

import com.pluralsight.springboot3fundamentals.entity.Organizer;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class OrganizerRepository {

  private final List<Organizer> organizers = List.of(
    new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
    new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment")
  );

  //--------------------------------------------------------------------------------------------------------------------

  public Optional<Organizer> findById(int organizerId) {
    return organizers.stream().
      filter(organizer -> organizer.getId() == organizerId).
      findAny();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public List<Organizer> findAll() {
    return organizers;
  }

  //--------------------------------------------------------------------------------------------------------------------

}
