package coursesystem.application.input.course;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateCourseInputDTO(String name,
                                    String description,
                                    BigDecimal price,
                                    UUID userId) {
  
}
