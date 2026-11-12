package coursesystem.application.output.user;

import java.util.UUID;

import coursesystem.domain.model.usercourse.UserType;


public record PurchaseCourseOutputDTO(
  UUID id,
  UUID courseId,
  UserType type
) {

}
