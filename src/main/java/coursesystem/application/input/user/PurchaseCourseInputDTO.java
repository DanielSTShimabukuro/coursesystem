package coursesystem.application.input.user;

import java.util.UUID;

public record PurchaseCourseInputDTO(
  UUID id,
  UUID courseId
) {
  
}
