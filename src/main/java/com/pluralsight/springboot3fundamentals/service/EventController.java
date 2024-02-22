package com.pluralsight.springboot3fundamentals.service;

import com.pluralsight.springboot3fundamentals.NoSuchListException;
import com.pluralsight.springboot3fundamentals.entity.Organizer;
import com.pluralsight.springboot3fundamentals.entity.Event;
import com.pluralsight.springboot3fundamentals.entity.Product;
import com.pluralsight.springboot3fundamentals.repository.EventRepository;
import com.pluralsight.springboot3fundamentals.repository.OrganizerRepository;
import com.pluralsight.springboot3fundamentals.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path="/tickets")
public class EventController {

  private final OrganizerRepository organizerRepository;
  private final EventRepository eventRepository;
  private final ProductRepository productRepository;

  //--------------------------------------------------------------------------------------------------------------------

  public EventController(
    OrganizerRepository organizerRepository,
    EventRepository eventRepository,
    ProductRepository productRepository
  ) {
    this.organizerRepository = organizerRepository;
    this.eventRepository = eventRepository;
    this.productRepository = productRepository;
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path = "/organizers/")
  public List<Organizer> getAllOrganizers() {
    List<Organizer> lst = this.organizerRepository.findAll();

    if (lst.size() > 0) return lst;

    throw new NoSuchListException("No organizers found");
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path = "/organizers/{id}")
  public Organizer getOrganizerbyId(@PathVariable("id") int organizerId) {
    return this.organizerRepository.
      findById(organizerId).
      orElseThrow(
        () ->new NoSuchElementException(String.format("Organizer with id '%d' not found", organizerId))
      );
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path = "/events")
  public List<Event> getEvents(
    @RequestParam("organizerId") Optional<Integer> organizerId,
    @RequestParam("venueId") Optional<Integer> venueId
  ) {
    List<Event> events;
    String message;

    if (organizerId.isPresent() && venueId.isPresent()) {
      events = this.eventRepository.findByOrganizerIdAndVenueId(organizerId.get(), venueId.get());

      if (events.size() > 0) return events;

      message = String.format(
        "Events with organizerId '%d' and venueId '%d' not found",
        organizerId.get(), venueId.get()
      );
    }
    else if (organizerId.isPresent()) {
      events = this.eventRepository.findByOrganizerId(organizerId.get());

      if (events.size() > 0) return events;

      message = String.format("Events with organizerId '%d' not found", organizerId.get());
    }
    else if (venueId.isPresent()) {
      events = this.eventRepository.findByVenueId(venueId.get());

      if (events.size() > 0) return events;

      message = String.format("Events with venueId '%d' not found", venueId.get());
    }
    else {
      message = "No events found";
    }

    throw new NoSuchListException(message);
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path="/events/")
  public List<Event> getAllEvents() {
    List<Event> events = this.eventRepository.findAll();

    if (events.size() > 0) return events;

    throw new NoSuchListException("No events found");
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path="/events/{id}")
  public Event getEventById(@PathVariable("id") int eventId) {
    return this.eventRepository.
      findById(eventId).
      orElseThrow(
        () -> new NoSuchElementException(String.format("Event with id '%d' not found", eventId))
      );
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path = "/products/")
  public List<Product> getAllProducts() {
    List<Product> products = this.productRepository.findAll();

    if (products.size() > 0) return products;
    else throw new NoSuchListException(("No products found"));
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path = "/products")
  public List<Product> getProductsbyEventId(@RequestParam("eventId") Optional<Integer> eventId) {
    List<Product> products;

    if (eventId.isPresent()) {
      products = this.productRepository.findByEventId(eventId.get());
      if (products.size() > 0) return products;
    }

    throw new NoSuchListException(String.format("Products with eventId '%d' not found", eventId.get()));
  }

  //--------------------------------------------------------------------------------------------------------------------

  @GetMapping(path = "/products/{id}")
  public Product getProductById(@PathVariable("id") int productId) {
    return this.productRepository.
      findById(productId).
      orElseThrow(
        () -> new NoSuchElementException(String.format("Product with 'id' %d not found", productId))
      );
  }

  //--------------------------------------------------------------------------------------------------------------------

}
