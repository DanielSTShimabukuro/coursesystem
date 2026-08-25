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
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Course(null, null, BigDecimal.TEN));

    assertEquals("Invalid Name.", ex.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithBlankName() {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Course(" ", null, BigDecimal.TEN));

    assertEquals("Invalid Name.", ex.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenInstantiateCourseWithNullPrice() {
    IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Course("Name", null, null));

    assertEquals("Invalid Price.", ex.getMessage());
  }
}
