package coursesystem.domain.entities.course;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CourseTest {
  @Test
  void shouldInstantiateCourseWithValidData() {
    String name = "Course";
    String description = "Description";
    BigDecimal price = BigDecimal.TEN;
    Course course = new Course(name, description, price);

    assertEquals(name, course.name());
    assertEquals(description, course.description());
    assertEquals(price, course.price());
  }
}
