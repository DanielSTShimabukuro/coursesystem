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

    if (courseReaction == null || (courseStatus == CourseStatus.NOT_STARTED && courseReaction != CourseReaction.NONE)) throw new IllegalArgumentException("Invalid CourseReaction");

    if (userId == null) throw new IllegalArgumentException("Invalid UserId.");

    if (courseId == null) throw new IllegalArgumentException("Invalid CourseId.");
  }

  public UserCourse(UserType userType,
                    CourseStatus courseStatus,
                    CourseReaction courseReaction,
                    UUID userId,
                    UUID courseId) {
    this(null,
          userType,
          courseStatus,
          courseReaction,
          userId,
          courseId);
  }
}
