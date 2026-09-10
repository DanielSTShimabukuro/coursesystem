package coursesystem.domain.model.course;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public record Course(UUID id,
                      String name,
                      String description,
                      BigDecimal price,
                      Instant createdAt,
                      Set<UUID> userCourseIds) {
  public Course {
    name = name == null ? null : name.trim();
    description = description == null ? null : description.trim();

    if (name == null  || name.length() > 150 || name.length() < 2) throw new IllegalArgumentException("Invalid Name.");

    if (description != null && (description.length() > 1000 || description.length() < 10)) throw new IllegalArgumentException("Invalid Description.");

    if (price == null || price.signum() < 0 || price.precision() > 8 || price.scale() > 2) throw new IllegalArgumentException("Invalid Price.");
  }

  public Course(String name,
                String description,
                BigDecimal price) {
    this(null,
          name,
          description,
          price,
          null,
          new HashSet<>());
  }
}
