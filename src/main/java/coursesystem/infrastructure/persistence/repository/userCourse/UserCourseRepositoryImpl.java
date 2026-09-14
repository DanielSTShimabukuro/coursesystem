package coursesystem.infrastructure.persistence.repository.userCourse;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import coursesystem.domain.model.usercourse.UserCourse;
import coursesystem.domain.repository.UserCourseRepository;
import coursesystem.infrastructure.persistence.mapper.UserCoursePersistenceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Repository 
public class UserCourseRepositoryImpl implements UserCourseRepository {
  private final UserCoursePersistenceMapper mapper;
  private final UserCourseJpaRepository jpaRepository;

  @Override 
  public Optional<UserCourse> findByUserIdAndCourseId(UUID userId, UUID courseId) {
    return this.jpaRepository.findByUserIdAndCourseId(userId, courseId).map(userCourse -> this.mapper.toDomain(userCourse));
  }

  @Override 
  public Set<UserCourse> findAllByUserId(UUID userId) {
    return this.jpaRepository.findAllByUserId(userId).stream().map(userCourse -> this.mapper.toDomain(userCourse)).collect(Collectors.toSet());
  }
}
