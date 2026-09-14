package coursesystem.application.input.course;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateCourseInputDTO(String name,
                                    String description,
                                    BigDecimal price,
                                    UUID userId) {
  
}
