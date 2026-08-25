package coursesystem.domain.entities.course;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CourseTest {
  private static final String VALID_NAME = "Course";
  private static final String VALID_DESCRIPTION = "Description";
  private static final BigDecimal VALID_PRICE = BigDecimal.TEN;

  @Test
  void shouldInstantiateCourseWithValidData() {
    Course course = new Course(VALID_NAME, VALID_DESCRIPTION, VALID_PRICE);
  
    assertAll(
      () -> assertEquals(VALID_NAME, course.name()),
      () -> assertEquals(VALID_DESCRIPTION, course.description()),
      () -> assertEquals(VALID_PRICE, course.price()));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithNullName() {
    assertThrows(IllegalArgumentException.class, () -> new Course(null, null, VALID_PRICE));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithBlankName() {
    assertThrows(IllegalArgumentException.class, () -> new Course(" ", null, VALID_PRICE));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithNullPrice() {
    assertThrows(IllegalArgumentException.class, () -> new Course(VALID_NAME, null, null));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithPriceLowenThanZero() {
    assertThrows(IllegalArgumentException.class, () -> new Course(VALID_NAME, null, BigDecimal.valueOf(-1000)));
  }
}
