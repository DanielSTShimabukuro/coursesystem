package coursesystem.domain.repository;

import java.util.Optional;
import java.util.UUID;

import coursesystem.domain.model.user.User;

public interface UserRepository {
  User save(User user);

  Optional<User> findById(UUID id);
}
