package coursesystem.infrastructure.persistence.repository.userCourse;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import coursesystem.application.exceptions.NotFoundException;
import coursesystem.domain.model.usercourse.UserCourse;
import coursesystem.domain.repository.UserCourseRepository;
import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;
import coursesystem.infrastructure.persistence.entity.UserCourseJpaEntity;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;
import coursesystem.infrastructure.persistence.mapper.UserCoursePersistenceMapper;
import coursesystem.infrastructure.persistence.repository.course.CourseJpaRepository;
import coursesystem.infrastructure.persistence.repository.user.UserJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Repository 
public class UserCourseRepositoryImpl implements UserCourseRepository {
  private final UserCoursePersistenceMapper mapper;
  private final UserJpaRepository userJpaRepository;
  private final CourseJpaRepository courseJpaRepository;
  private final UserCourseJpaRepository jpaRepository;

  @Override
  public UserCourse save(UserCourse usercourseDomain) {
    UserJpaEntity user = this.userJpaRepository.findById(usercourseDomain.userId()).orElseThrow(() -> new NotFoundException("User Not Found."));
    CourseJpaEntity course = this.courseJpaRepository.findById(usercourseDomain.courseId()).orElseThrow(() -> new NotFoundException("Course Not Found."));
    UserCourseJpaEntity userCourse = this.mapper.toEntity(usercourseDomain, user, course);

    this.jpaRepository.save(userCourse);

    return this.mapper.toDomain(userCourse);
  }

  @Override 
  public boolean existsByUserIdAndCourseId(UUID userId, UUID courseId) {
    return this.jpaRepository.existsByUserIdAndCourseId(userId, courseId);
  }

  @Override 
  public Optional<UserCourse> findByUserIdAndCourseId(UUID userId, UUID courseId) {
    return this.jpaRepository.findByUserIdAndCourseId(userId, courseId).map(userCourse -> this.mapper.toDomain(userCourse));
  }

  @Override 
  public Set<UserCourse> findAllByUserId(UUID userId) {
    return this.jpaRepository.findAllByUserId(userId).stream().map(userCourse -> this.mapper.toDomain(userCourse)).collect(Collectors.toSet());
  }
}
