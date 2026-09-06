package coursesystem.application.mapper;

import coursesystem.application.input.course.CreateCourseInputDTO;
import coursesystem.domain.model.course.Course;

public class CourseApplicationMapper {
  public Course toDomain(CreateCourseInputDTO input) {
    return new Course(input.name(), input.description(), input.price());
  }
}
