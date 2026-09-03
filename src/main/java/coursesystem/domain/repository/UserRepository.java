package coursesystem.domain.repository;

import coursesystem.domain.model.user.User;

public interface UserRepository {
  public User save(User user);
}
