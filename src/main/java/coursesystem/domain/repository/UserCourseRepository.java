package coursesystem.domain.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import coursesystem.domain.model.usercourse.UserCourse;

public interface UserCourseRepository {
  boolean existsByUserIdAndCourseId(UUID userId, UUID courseId);

  Optional<UserCourse> findByUserIdAndCourseId(UUID userId, UUID courseId);

  Set<UserCourse> findAllByUserId(UUID userId);
}
