package coursesystem.domain.repository;

import coursesystem.domain.model.course.Course;

public interface CourseRepository {
  Course save(Course course);
}
