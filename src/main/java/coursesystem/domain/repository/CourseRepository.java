package coursesystem.domain.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import coursesystem.domain.model.course.Course;

public interface CourseRepository {
  Course save(Course domainCourse, UUID userId);
  Course save(Course domainCourse);

  Optional<Course> findById(UUID id);

  Set<Course> findAll();
}
