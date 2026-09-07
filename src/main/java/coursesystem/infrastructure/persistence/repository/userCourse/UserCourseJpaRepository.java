package coursesystem.infrastructure.persistence.repository.userCourse;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import coursesystem.infrastructure.persistence.entity.UserCourseJpaEntity;

public interface UserCourseJpaRepository extends JpaRepository<UserCourseJpaEntity, UUID> {
  
}
