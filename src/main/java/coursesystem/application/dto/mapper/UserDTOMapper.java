package coursesystem.application.dto.mapper;

import coursesystem.application.dto.input.user.CreateUserInputDTO;
import coursesystem.domain.model.user.User;

public class UserDTOMapper {
  public User toDomain(CreateUserInputDTO input) {
    return new User(input.email(), input.username(), input.password());
  }
}
