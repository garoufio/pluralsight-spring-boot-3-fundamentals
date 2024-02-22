package com.pluralsight.springboot3fundamentals.repository;

import org.springframework.stereotype.Repository;
import com.pluralsight.springboot3fundamentals.entity.Product;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@Repository
public class ProductRepository {

  private final List<Product> products = List.of(
    new Product(
      801, 501, "Standard", "Standard Conference Ticket", new BigDecimal("499.00")
    ),
    new Product(
      802, 501, "Premium", "Premium Conference Ticket", new BigDecimal("649.00")
    ),
    new Product(
      803, 502, "Standard", "Developer Day Ticket", new BigDecimal("195.50")
    ),
    new Product(
      804, 503, "Regular", "Regular Entrance", new BigDecimal("35.00")
    ),
    new Product(
      805, 503, "VIP", "VIP Bonus Entrance", new BigDecimal("65.00")
    )
  );

  //--------------------------------------------------------------------------------------------------------------------

  public Optional<Product> findById(int id) {
    return products.stream().
      filter(product -> product.getId() == id).
      findAny();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public List<Product> findByEventId(int eventId) {
    return products.stream().
      filter(product -> product.getEventId() == eventId).
      toList();
  }

  //--------------------------------------------------------------------------------------------------------------------

  public List<Product> findAll() {
    return products;
  }

  //--------------------------------------------------------------------------------------------------------------------

}
