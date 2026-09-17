package coursesystem.infrastructure.persistence.repository.userCourse;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import coursesystem.infrastructure.persistence.entity.UserCourseJpaEntity;

public interface UserCourseJpaRepository extends JpaRepository<UserCourseJpaEntity, UUID> {
  boolean existsByUserIdAndCourseId(UUID userID, UUID courseId);

  Optional<UserCourseJpaEntity> findByUserIdAndCourseId(UUID userId, UUID courseId);

  Set<UserCourseJpaEntity> findAllByUserId(UUID userId);
}
