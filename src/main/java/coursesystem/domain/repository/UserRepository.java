package coursesystem.domain.repository;

import java.util.Optional;
import java.util.UUID;

import coursesystem.domain.model.user.User;

public interface UserRepository {
  User save(User domainUser);

  boolean existsByEmail(String email);
  boolean existsByEmailAndIdNot(String email, UUID id);
  boolean existsByUsername(String username);
  boolean existsByUsernameAndIdNot(String username, UUID id);

  Optional<User> findById(UUID id);

  void delete(User domainUser);
}
