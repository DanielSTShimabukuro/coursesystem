package coursesystem.infrastructure.persistence.repository.user;

import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;
import coursesystem.infrastructure.persistence.mapper.UserPersistenceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
  private final UserJpaRepository jpaRepository;
  private final UserPersistenceMapper mapper;

  @Override
  public User save(User domainUser) {
    UserJpaEntity user = this.mapper.toEntity(domainUser);

    this.jpaRepository.save(user);

    return this.mapper.toDomain(user);
  }
}
