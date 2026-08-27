package coursesystem.domain.entity.usercourse;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class UserCourseTest {
  private static final UserType VALID_USER_TYPE = UserType.OWNER;
  private static final CourseStatus VALID_COURSE_STATUS = CourseStatus.COMPLETED;
  private static final CourseReaction VALID_COURSE_REACTION = CourseReaction.LIKE;

  @Test
  void shouldInstantiateUserCourseWithValidData() {
    UserCourse userCourse = new UserCourse(VALID_USER_TYPE, VALID_COURSE_STATUS, VALID_COURSE_REACTION);

    assertAll(() -> assertEquals(VALID_USER_TYPE, userCourse.userType()),
              () -> assertEquals(VALID_COURSE_STATUS, userCourse.courseStatus()),
              () -> assertEquals(VALID_COURSE_REACTION, userCourse.courseReaction()));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserCourseWithNullUserType() {
    assertThrows(IllegalArgumentException.class, () -> new UserCourse(null, VALID_COURSE_STATUS, null));
  }
  
  @Test
  void shouldThrowExceptionWhenInstantiateUserCourseWithNullCourseStatus() {
    assertThrows(IllegalArgumentException.class, () -> new UserCourse(VALID_USER_TYPE, null, null));
  }
}
