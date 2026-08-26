package coursesystem.domain.entity.usercourse;

public record UserCourse(CourseStatus courseStatus,
                          CourseReaction courseReaction,
                          UserType userType
) {
  public UserCourse {
    if (courseStatus == null) throw new IllegalArgumentException("Invalid CourseStatus.");

    if (userType == null) throw new IllegalArgumentException("Invalid UserType.");
  }
}
