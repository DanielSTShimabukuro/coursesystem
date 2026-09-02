package coursesystem.domain.repository;

import coursesystem.domain.entity.user.User;

public interface UserRepository {
  public User save(User user);
}
