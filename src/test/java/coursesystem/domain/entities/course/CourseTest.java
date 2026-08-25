package coursesystem.domain.entities.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CourseTest {
  @Test
  void shouldInstantiateCourseWithValidData() {
    String name = "Course";
    BigDecimal price = BigDecimal.TEN;
    Course course = new Course(name, null, price);

    assertEquals(name, course.name());
    assertEquals(price, course.price());
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithNullName() {
    assertThrows(IllegalArgumentException.class, () -> new Course(null, null, BigDecimal.TEN));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithBlankName() {
    assertThrows(IllegalArgumentException.class, () -> new Course(" ", null, BigDecimal.TEN));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithNullPrice() {
    assertThrows(IllegalArgumentException.class, () -> new Course("Name", null, null));
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithPriceLowenThanZero() {
    assertThrows(IllegalArgumentException.class, () -> new Course("Name", null, BigDecimal.valueOf(-1000)));
  }
}
