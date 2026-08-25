package coursesystem.domain.entities.usercourse;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserCourseTest {
  @Test
  void shouldInstantiateUserCourseWithValidData() {
    final CourseStatus courseStatus = CourseStatus.COMPLETED;
    final CourseReaction courseReaction = CourseReaction.LIKE;
    final UserType userType = UserType.OWNER;

    UserCourse userCourse = new UserCourse(courseStatus, courseReaction, userType);

    assertAll(() -> assertEquals(courseStatus, userCourse.courseStatus()),
              () -> assertEquals(courseReaction, userCourse.courseReaction()),
              () -> assertEquals(userType, userCourse.userType()));
  }
}
