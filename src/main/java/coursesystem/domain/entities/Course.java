package coursesystem.domain.entities;

import java.math.BigDecimal;

public record Course(String name,
                      String description,
                      BigDecimal price) {
  public Course {
    if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid Name.");

    if (description == null || description.isBlank()) throw new IllegalArgumentException("Invalid Description.");

    if (price == null || price.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Invalid Price.");
  }
}
