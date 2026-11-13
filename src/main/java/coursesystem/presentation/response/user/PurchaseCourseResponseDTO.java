package coursesystem.presentation.response.user;

import java.util.UUID;

import coursesystem.domain.model.usercourse.UserType;

public record PurchaseCourseResponseDTO(
  UUID id,
  UUID courseId,
  UserType type
) {
  
}
