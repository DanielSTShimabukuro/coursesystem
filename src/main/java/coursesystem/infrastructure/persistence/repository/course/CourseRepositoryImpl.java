package coursesystem.infrastructure.persistence.repository.course;

import coursesystem.domain.model.course.Course;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;
import coursesystem.infrastructure.persistence.mapper.CoursePersistenceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
public class CourseRepositoryImpl implements CourseRepository {
  private final CoursePersistenceMapper mapper;
  private final CourseJpaRepository jpaRepository;

  @Override 
  public Course save(Course domainCourse) {
    CourseJpaEntity course = this.mapper.toEntity(domainCourse);

    this.jpaRepository.save(course);

    return this.mapper.toDomain(course);
  }
}
