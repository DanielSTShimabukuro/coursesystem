package coursesystem.infrastructure.persistence.mapper;

import java.util.stream.Collectors;

import coursesystem.domain.model.course.Course;
import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;

public class CoursePersistenceMapper {
  public CourseJpaEntity toEntity(Course domainCourse, UserJpaEntity user) {
    return new CourseJpaEntity(domainCourse.name(), domainCourse.description(), domainCourse.price(), user);
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
