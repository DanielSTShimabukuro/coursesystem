package coursesystem.infrastructure.persistence.repository.course;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import coursesystem.infrastructure.persistence.entity.CourseJpaEntity;

public interface CourseJpaRepository extends JpaRepository<CourseJpaEntity, UUID> {
  
}
