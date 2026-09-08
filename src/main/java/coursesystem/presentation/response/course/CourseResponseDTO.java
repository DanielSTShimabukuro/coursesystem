package coursesystem.presentation.response.course;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public record CourseResponseDTO(UUID id,
                                String name,
                                String description,
                                BigDecimal price,
                                Set<UUID> userCourseIds) {
  
}
