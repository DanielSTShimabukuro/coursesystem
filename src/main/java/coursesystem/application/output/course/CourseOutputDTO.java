package coursesystem.application.output.course;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record CourseOutputDTO(UUID id,
                              String name,
                              String description,
                              BigDecimal price,
                              Instant createdAt,
                              Set<UUID> userCourseIds) {
  
}
