package coursesystem.domain.model.usercourse;

import java.util.UUID;

public record UserCourse(UUID id,
                          UserType userType,
                          CourseStatus courseStatus,
                          CourseReaction courseReaction,
                          UUID userId,
                          UUID courseId) {
  public UserCourse {
    if (userType == null) throw new IllegalArgumentException("Invalid UserType.");

    if (courseStatus == null) throw new IllegalArgumentException("Invalid CourseStatus.");

    if (courseReaction == null) throw new IllegalArgumentException("Invalid CourseReaction");
  }

  public UserCourse(UserType userType,
                    CourseStatus courseStatus,
                    CourseReaction courseReaction) {
    this(null,
          userType,
          courseStatus,
          courseReaction,
          null,
          null);
  }
}
