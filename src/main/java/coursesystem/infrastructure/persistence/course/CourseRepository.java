package coursesystem.infrastructure.persistence.course;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseJpaEntity, UUID> {
  
}
