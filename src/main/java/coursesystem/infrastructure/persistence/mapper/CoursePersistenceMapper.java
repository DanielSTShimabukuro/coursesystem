package coursesystem.infrastructure.persistence.mapper;

import java.util.stream.Collectors;

import coursesystem.domain.model.course.Course;
import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;

public class CoursePersistenceMapper {
  public CourseJpaEntity toEntity(Course domainCourse) {
    return new CourseJpaEntity(domainCourse.name(), domainCourse.description(), domainCourse.price());
  }

  public Course toDomain(CourseJpaEntity course) {
    return new Course(course.getId(),
                      course.getName(),
                      course.getDescription(),
                      course.getPrice(),
                      course.getCreatedAt(),
                      course.getUsersCourses().stream().map(userCourse -> userCourse.getId()).collect(Collectors.toSet()));
  }
}
