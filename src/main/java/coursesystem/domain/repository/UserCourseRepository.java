package coursesystem.domain.repository;

import java.util.Set;
import java.util.UUID;

import coursesystem.domain.model.usercourse.UserCourse;

public interface UserCourseRepository {
  Set<UserCourse> findAllByUserId(UUID userId);
}
