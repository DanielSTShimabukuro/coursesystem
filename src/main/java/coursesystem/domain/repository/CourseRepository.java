package coursesystem.domain.repository;

import java.util.UUID;

import coursesystem.domain.model.course.Course;

public interface CourseRepository {
  Course save(Course domainCourse, UUID userId);
}
