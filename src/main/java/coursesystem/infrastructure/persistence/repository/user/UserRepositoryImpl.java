package coursesystem.infrastructure.persistence.repository.user;

import java.util.Optional;
import java.util.UUID;

import coursesystem.domain.model.user.User;
import coursesystem.domain.repository.UserRepository;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;
import coursesystem.infrastructure.persistence.mapper.UserPersistenceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
  private final UserPersistenceMapper mapper;
  private final UserJpaRepository jpaRepository;

  @Override
  public User save(User domainUser) {
    UserJpaEntity user = this.mapper.toEntity(domainUser);

    this.jpaRepository.save(user);

    return this.mapper.toDomain(user);
  }

  @Override
  public boolean existsByEmail(String email) {
    return this.jpaRepository.existsByEmail(email);
  }

  @Override 
  public boolean existsByEmailAndIdNot(String email, UUID id) {
    return this.jpaRepository.existsByEmailAndIdNot(email, id);
  }

  @Override 
  public boolean existsByUsername(String username) {
    return this.jpaRepository.existsByUsername(username);
  }

  @Override 
  public boolean existsByUsernameAndIdNot(String username, UUID id) {
    return this.existsByUsernameAndIdNot(username, id);
  }

  @Override 
  public Optional<User> findById(UUID id) {
    return this.jpaRepository.findById(id).map(user -> this.mapper.toDomain(user)); 
  }
}
