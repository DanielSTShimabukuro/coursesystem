package coursesystem.infrastructure.persistence.mapper;

import coursesystem.domain.model.user.User;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;

public class UserMapper {
  public UserJpaEntity toEntity(User domainUser) {
    return new UserJpaEntity(domainUser.email(), domainUser.username(), domainUser.password());
  }

  public User toDomain(UserJpaEntity user) {
    return new User(user.getEmail(), user.getUsername(), user.getPassword());
  }
}
