package coursesystem.domain.repository;

import java.util.Optional;
import java.util.UUID;

import coursesystem.domain.model.user.User;

public interface UserRepository {
  User save(User user);

  boolean existsByEmail(String email);
  boolean existsByEmailAndIdNot(String email, UUID id);
  boolean existsByUsername(String username);

  Optional<User> findById(UUID id);
}
