package coursesystem.application.input.course;

import java.math.BigDecimal;

public record UpdateCourseInputDTO(String name,
                                    String description,
                                    BigDecimal price) {
  
}
