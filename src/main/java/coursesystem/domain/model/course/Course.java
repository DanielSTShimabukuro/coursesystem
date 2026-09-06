package coursesystem.domain.model.course;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Course(UUID id,
                      String name,
                      String description,
                      BigDecimal price,
                      Instant createdAt) {
  public Course {
    if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid Name.");

    if (price == null || price.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Invalid Price.");
  }

  public Course(String name,
                String description,
                BigDecimal price) {
    this(null,
          name,
          description,
          price,
          null);
  }
}
