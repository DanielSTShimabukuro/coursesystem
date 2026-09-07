package coursesystem.domain.repository;

import coursesystem.domain.model.usercourse.UserCourse;

public interface UserCourseRepository {
  UserCourse save(UserCourse userCourse);
}
