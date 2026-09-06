package coursesystem.application.input.course;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateCourseInputDTO(UUID userId,
                                    String name,
                                    String description,
                                    BigDecimal price) {
  
}
