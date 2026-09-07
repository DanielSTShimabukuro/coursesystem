package coursesystem.infrastructure.persistence.mapper;

import coursesystem.domain.model.usercourse.UserCourse;
import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;
import coursesystem.infrastructure.persistence.entity.UserCourseJpaEntity;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;

public class UserCoursePersistenceMapper {
  public UserCourseJpaEntity toEntity(UserCourse domainUserCourse, UserJpaEntity user, CourseJpaEntity course) {
    return new UserCourseJpaEntity(domainUserCourse.userType(), 
                                    domainUserCourse.courseStatus(), 
                                    domainUserCourse.courseReaction(), 
                                    user,
                                    course);
  }

  public UserCourse toDomain(UserCourseJpaEntity userCourse) {
    return new UserCourse(userCourse.getId(), 
                          userCourse.getUserType(),
                          userCourse.getCourseStatus(),
                          userCourse.getCourseReaction(),
                          userCourse.getUser().getId(),
                          userCourse.getCourse().getId());
  }
}
