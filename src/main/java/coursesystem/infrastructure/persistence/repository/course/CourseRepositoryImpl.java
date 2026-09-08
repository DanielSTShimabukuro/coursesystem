package coursesystem.infrastructure.persistence.repository.course;

import java.util.UUID;

import coursesystem.domain.model.course.Course;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;
import coursesystem.infrastructure.persistence.mapper.CoursePersistenceMapper;
import coursesystem.infrastructure.persistence.repository.user.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
public class CourseRepositoryImpl implements CourseRepository {
  private final CoursePersistenceMapper mapper;
  private final UserJpaRepository userJpaRepository;
  private final CourseJpaRepository jpaRepository;

  @Override 
  public Course save(Course domainCourse, UUID userId) {
    UserJpaEntity user = this.userJpaRepository.getReferenceById(userId);
    CourseJpaEntity course = this.mapper.toEntity(domainCourse, user);

    this.jpaRepository.save(course);

    return this.mapper.toDomain(course);
  }
}
