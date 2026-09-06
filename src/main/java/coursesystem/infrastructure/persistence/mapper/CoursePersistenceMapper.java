package coursesystem.infrastructure.persistence.mapper;

import coursesystem.domain.model.course.Course;
import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;

public class CoursePersistenceMapper {
  public CourseJpaEntity toEntity(Course course) {
    return new CourseJpaEntity(course.name(), course.description(), course.price());
  }
}
