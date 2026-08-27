package coursesystem.domain.entity.usercourse;

public record UserCourse(UserType userType,
                          CourseStatus courseStatus,
                          CourseReaction courseReaction
) {
  public UserCourse {
    if (userType == null) throw new IllegalArgumentException("Invalid UserType.");

    if (courseStatus == null) throw new IllegalArgumentException("Invalid CourseStatus.");
  }
}
