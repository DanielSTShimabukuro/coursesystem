package coursesystem.infrastructure.persistence.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import coursesystem.domain.model.user.User;
import coursesystem.infrastructure.persistence.entity.UserJpaEntity;

@Component 
public class UserPersistenceMapper {
  public UserJpaEntity toEntity(User domainUser) {
    return new UserJpaEntity(domainUser.email(), domainUser.username(), domainUser.password());
  }

  public User toDomain(UserJpaEntity user) {
    return new User(user.getId(), 
                    user.getEmail(), 
                    user.getUsername(), 
                    user.getPassword(), 
                    user.getCreatedAt(), 
                    user.getUpdatedAt(), 
                    user.getUsersCourses().stream().map(usercourse -> usercourse.getId()).collect(Collectors.toSet()));
  }
}
