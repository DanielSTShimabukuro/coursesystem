package coursesystem.domain.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import coursesystem.domain.model.usercourse.UserCourse;

public interface UserCourseRepository {
  Optional<UserCourse> findUserCourseByUserIdAndCourseId(UUID userId, UUID courseId);

  Set<UserCourse> findAllByUserId(UUID userId);
}
