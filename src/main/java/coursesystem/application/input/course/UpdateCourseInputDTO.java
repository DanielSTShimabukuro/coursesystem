package coursesystem.application.input.course;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateCourseInputDTO(UUID id,
                                    String name,
                                    String description,
                                    BigDecimal price) {
  
}
