package coursesystem.domain.model.usercourse;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class UserCourseTest {
  private static final UserType VALID_USER_TYPE = UserType.OWNER;
  private static final CourseStatus VALID_COURSE_STATUS = CourseStatus.COMPLETED;
  private static final CourseReaction VALID_COURSE_REACTION = CourseReaction.LIKE;
  private static final UUID VALID_USERID = UUID.fromString("764aa964-fcac-41ba-a55c-1fcdce4e461a");
  private static final UUID VALID_COURSEID = UUID.fromString("66940b82-3d2a-4a1e-87cd-f82bba752982");

  @Test
  void shouldInstantiateUserCourseWithValidData() {
    UserCourse userCourse = new UserCourse(VALID_USER_TYPE, 
                                            VALID_COURSE_STATUS, 
                                            VALID_COURSE_REACTION,
                                            VALID_USERID,
                                            VALID_COURSEID);

    assertAll(() -> assertEquals(VALID_USER_TYPE, userCourse.userType()),
              () -> assertEquals(VALID_COURSE_STATUS, userCourse.courseStatus()),
              () -> assertEquals(VALID_COURSE_REACTION, userCourse.courseReaction()),
              () -> assertEquals(VALID_USERID, userCourse.userId()),
              () -> assertEquals(VALID_COURSEID, userCourse.courseId()));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateUserCourseWithNullUserType() {
    assertThrows(IllegalArgumentException.class, () -> new UserCourse(null, 
                                                                      VALID_COURSE_STATUS, 
                                                                      VALID_COURSE_REACTION,
                                                                      VALID_USERID,
                                                                      VALID_COURSEID));
  }
  
  @Test
  void shouldThrowExceptionWhenInstantiateUserCourseWithNullCourseStatus() {
    assertThrows(IllegalArgumentException.class, () -> new UserCourse(VALID_USER_TYPE, 
                                                                      null, 
                                                                      VALID_COURSE_REACTION,
                                                                      VALID_USERID,
                                                                      VALID_COURSEID));
  }
}
