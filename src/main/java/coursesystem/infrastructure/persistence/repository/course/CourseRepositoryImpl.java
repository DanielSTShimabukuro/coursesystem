package coursesystem.infrastructure.persistence.repository.course;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import coursesystem.domain.model.course.Course;
import coursesystem.domain.repository.CourseRepository;
import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;
import coursesystem.infrastructure.persistence.mapper.CoursePersistenceMapper;
import coursesystem.infrastructure.persistence.repository.user.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Repository 
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

  @Override 
  public Course save(Course domainCourse) {
    CourseJpaEntity course = this.mapper.toEntity(domainCourse);

    this.jpaRepository.save(course);

    return this.mapper.toDomain(course);
  }

  @Override 
  public Optional<Course> findById(UUID id) {
    return this.jpaRepository.findById(id).map(course -> this.mapper.toDomain(course));
  }

  @Override 
  public Set<Course> findAll() {
    return this.jpaRepository.findAll().stream().map(course -> this.mapper.toDomain(course)).collect(Collectors.toSet());
  }
}
